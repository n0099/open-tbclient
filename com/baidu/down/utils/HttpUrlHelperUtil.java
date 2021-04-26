package com.baidu.down.utils;

import java.io.UnsupportedEncodingException;
import java.net.IDN;
import java.net.URLEncoder;
import java.util.Locale;
/* loaded from: classes2.dex */
public class HttpUrlHelperUtil {
    public static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, com.baidu.android.imsdk.internal.Constants.SHORT_PING_CMD_TYPE, 102};

    public static boolean containsInvalidHostnameAsciiCodes(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int decodeHexDigit(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    return -1;
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    public static int delimiterOffset(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String domainToAscii(String str) {
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static int skipLeadingAsciiWhitespace(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char charAt = str.charAt(i4);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static String writeByte(int i2) {
        return new String(new byte[]{(byte) i2});
    }

    public static String writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        byte[] bArr = new byte[numberOfTrailingZeros];
        for (int i2 = numberOfTrailingZeros - 1; i2 >= 0; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        try {
            return URLEncoder.encode(new String(bArr), "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String writeUtf8CodePoint(int i2) {
        byte[] bArr;
        byte[] bArr2;
        if (i2 < 128) {
            bArr2 = new byte[]{(byte) i2};
        } else {
            if (i2 < 2048) {
                bArr = new byte[]{(byte) ((i2 >> 6) | 192), (byte) ((i2 & 63) | 128)};
            } else if (i2 < 65536) {
                if (i2 >= 55296 && i2 <= 57343) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
                }
                bArr = new byte[]{(byte) ((i2 >> 12) | 224), (byte) (((i2 >> 6) & 63) | 128), (byte) ((i2 & 63) | 128)};
            } else if (i2 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
            } else {
                bArr = new byte[]{(byte) ((i2 >> 18) | 240), (byte) (((i2 >> 12) & 63) | 128), (byte) (((i2 >> 6) & 63) | 128), (byte) ((i2 & 63) | 128)};
            }
            bArr2 = bArr;
        }
        return new String(bArr2);
    }

    public static byte[] writeUtf8CodePoint2(int i2) {
        byte[] bArr;
        if (i2 < 128) {
            return new byte[]{(byte) i2};
        }
        if (i2 < 2048) {
            bArr = new byte[]{(byte) ((i2 >> 6) | 192), (byte) ((i2 & 63) | 128)};
        } else if (i2 < 65536) {
            if (i2 >= 55296 && i2 <= 57343) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
            }
            bArr = new byte[]{(byte) ((i2 >> 12) | 224), (byte) (((i2 >> 6) & 63) | 128), (byte) ((i2 & 63) | 128)};
        } else if (i2 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
        } else {
            bArr = new byte[]{(byte) ((i2 >> 18) | 240), (byte) (((i2 >> 12) & 63) | 128), (byte) (((i2 >> 6) & 63) | 128), (byte) ((i2 & 63) | 128)};
        }
        return bArr;
    }

    public static int delimiterOffset(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }
}
