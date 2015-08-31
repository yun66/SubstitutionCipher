import java.util.ArrayList;
import java.util.Scanner;

public class main {

	static double[] letterFrequency = new double[26];
	static ArrayList<String> substitutionHistory = new ArrayList<>();
	static StringBuilder cipherText;
	static StringBuilder decrypt;
	static Scanner in;
	static boolean quit = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userInput();
		letterFrequency();
		printFrequency();
		System.out.println("Substite letters in order to decrypt the cipher");
		System.out.println("Enter 1 to quit");
		System.out.println("Enter 2 to see substitution history");

		while (!quit) {
			decrypt();
		}

		in.close();

	}

	public static void userInput() {
		in = new Scanner(System.in);
		System.out.print("Please enter cipher text as one string: ");
		String s = in.next();
		cipherText = new StringBuilder(s);
		decrypt = new StringBuilder(s);

		// in.close();
	}

	public static void letterFrequency() {
		for (int i = 0; i < cipherText.length(); i++) {
			int x = cipherText.charAt(i) - 65;
			// System.out.println(x);
			letterFrequency[x] = letterFrequency[x] + 1;
		}
	}

	public static void printFrequency() {
		for (int i = 65; i <= 90; i++) {
			System.out.printf("%-5s", (char) i);
		}

		System.out.println();
		for (int i = 0; i < letterFrequency.length; i++) {
			System.out.printf("%-5.0f", letterFrequency[i]);
		}

		System.out.println();
		for (int i = 0; i < letterFrequency.length; i++) {
			System.out.printf("%-5.2f",
					(letterFrequency[i] / cipherText.length()));
		}

		System.out.println();
	}

	public static void decrypt() {

		// in = new Scanner(System.in);
		System.out.print("For letter: ");
		String a = in.next();
		a = a.substring(0, 1);
		if (a.equalsIgnoreCase("1")) {
			quit = true;

		}
		
		if (a.equalsIgnoreCase("2")) {
			for(String s : substitutionHistory)
			{
				System.out.println(s);
			}
			
			System.out.print("For letter: ");
			a = in.next();

		}
		System.out.print("Substitute: ");
		String b = in.next();
		b = b.substring(0, 1);
		ArrayList<Integer> charLocations = new ArrayList<>();
		//cipherText = cipherText.replace(a, b);

		for(int i = 0; i < cipherText.length(); i++)
		{
				if(cipherText.charAt(i) == a.charAt(0))
				{
					charLocations.add(i);
				}
		}
		
		for(int i : charLocations)
		{
			decrypt.setCharAt(i, b.charAt(0));
		}

		substitutionHistory.add("For every occurance of " + a
				+ ", you substituted " + b);
		System.out.println("Substituted " + a + " for " + b);
		System.out.println("This is the updated cipher text: " + decrypt);

	}

}
