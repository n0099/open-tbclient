package com.baidu.android.imsdk.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
/* loaded from: classes.dex */
public class Base64 {
    public static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    public static int decode(char c2) throws RuntimeException {
        int i;
        if (c2 < 'A' || c2 > 'Z') {
            if (c2 >= 'a' && c2 <= 'z') {
                i = c2 - 'a';
            } else if (c2 < '0' || c2 > '9') {
                if (c2 != '+') {
                    if (c2 != '/') {
                        if (c2 == '=') {
                            return 0;
                        }
                        throw new RuntimeException("unexpected code: " + c2);
                    }
                    return 63;
                }
                return 62;
            } else {
                i = (c2 - '0') + 26;
            }
            return i + 26;
        }
        return c2 - 'A';
    }

    public static String encode(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i = length - 3;
        int i2 = 0;
        loop0: while (true) {
            int i3 = 0;
            while (i2 <= i) {
                int i4 = ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
                stringBuffer.append(legalChars[(i4 >> 18) & 63]);
                stringBuffer.append(legalChars[(i4 >> 12) & 63]);
                stringBuffer.append(legalChars[(i4 >> 6) & 63]);
                stringBuffer.append(legalChars[i4 & 63]);
                i2 += 3;
                int i5 = i3 + 1;
                if (i3 >= 14) {
                    break;
                }
                i3 = i5;
            }
            stringBuffer.append(" ");
        }
        int i6 = 0 + length;
        if (i2 == i6 - 2) {
            int i7 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
            stringBuffer.append(legalChars[(i7 >> 18) & 63]);
            stringBuffer.append(legalChars[(i7 >> 12) & 63]);
            stringBuffer.append(legalChars[(i7 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i2 == i6 - 1) {
            int i8 = (bArr[i2] & 255) << 16;
            stringBuffer.append(legalChars[(i8 >> 18) & 63]);
            stringBuffer.append(legalChars[(i8 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }

    public static byte[] decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            decode(str, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                PrintStream printStream = System.err;
                printStream.println("Error while decoding BASE64: " + e2.toString());
            }
            return byteArray;
        } catch (IOException unused) {
            throw new RuntimeException();
        }
    }

    public static void decode(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length && str.charAt(i) <= ' ') {
                i++;
            } else if (i == length) {
                return;
            } else {
                int i2 = i + 2;
                int i3 = i + 3;
                int decode = (decode(str.charAt(i)) << 18) + (decode(str.charAt(i + 1)) << 12) + (decode(str.charAt(i2)) << 6) + decode(str.charAt(i3));
                outputStream.write((decode >> 16) & 255);
                if (str.charAt(i2) == '=') {
                    return;
                }
                outputStream.write((decode >> 8) & 255);
                if (str.charAt(i3) == '=') {
                    return;
                }
                outputStream.write(decode & 255);
                i += 4;
            }
        }
    }
}
