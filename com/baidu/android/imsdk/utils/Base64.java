package com.baidu.android.imsdk.utils;

import com.baidu.webkit.internal.ETAG;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
public class Base64 {
    private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    public static String encode(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i = length - 3;
        int i2 = 0;
        int i3 = 0;
        while (i3 <= i) {
            int i4 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
            stringBuffer.append(legalChars[(i4 >> 18) & 63]);
            stringBuffer.append(legalChars[(i4 >> 12) & 63]);
            stringBuffer.append(legalChars[(i4 >> 6) & 63]);
            stringBuffer.append(legalChars[i4 & 63]);
            int i5 = i3 + 3;
            int i6 = i2 + 1;
            if (i2 >= 14) {
                stringBuffer.append(" ");
                i6 = 0;
            }
            i2 = i6;
            i3 = i5;
        }
        if (i3 == (0 + length) - 2) {
            int i7 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16);
            stringBuffer.append(legalChars[(i7 >> 18) & 63]);
            stringBuffer.append(legalChars[(i7 >> 12) & 63]);
            stringBuffer.append(legalChars[(i7 >> 6) & 63]);
            stringBuffer.append(ETAG.EQUAL);
        } else if (i3 == (0 + length) - 1) {
            int i8 = (bArr[i3] & 255) << 16;
            stringBuffer.append(legalChars[(i8 >> 18) & 63]);
            stringBuffer.append(legalChars[(i8 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }

    private static int decode(char c) throws RuntimeException {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        if (c >= 'a' && c <= 'z') {
            return (c - 'a') + 26;
        }
        if (c >= '0' && c <= '9') {
            return (c - '0') + 26 + 26;
        }
        switch (c) {
            case '+':
                return 62;
            case '/':
                return 63;
            case '=':
                return 0;
            default:
                throw new RuntimeException("unexpected code: " + c);
        }
    }

    public static byte[] decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            decode(str, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                System.err.println("Error while decoding BASE64: " + e.toString());
            }
            return byteArray;
        } catch (IOException e2) {
            throw new RuntimeException();
        }
    }

    private static void decode(String str, OutputStream outputStream) throws IOException {
        int i = 0;
        int length = str.length();
        while (true) {
            if (i < length && str.charAt(i) <= ' ') {
                i++;
            } else if (i != length) {
                int decode = (decode(str.charAt(i)) << 18) + (decode(str.charAt(i + 1)) << 12) + (decode(str.charAt(i + 2)) << 6) + decode(str.charAt(i + 3));
                outputStream.write((decode >> 16) & 255);
                if (str.charAt(i + 2) != '=') {
                    outputStream.write((decode >> 8) & 255);
                    if (str.charAt(i + 3) != '=') {
                        outputStream.write(decode & 255);
                        i += 4;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
