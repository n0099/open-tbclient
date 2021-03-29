package com.baidu.down.utils;

import java.io.UnsupportedEncodingException;
import java.net.IDN;
import java.net.URLEncoder;
import java.util.Locale;
/* loaded from: classes.dex */
public class HttpUrlHelperUtil {
    public static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, com.baidu.android.imsdk.internal.Constants.SHORT_PING_CMD_TYPE, 102};

    public static boolean containsInvalidHostnameAsciiCodes(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
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

    public static int delimiterOffset(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
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

    public static int skipLeadingAsciiWhitespace(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static String writeByte(int i) {
        return new String(new byte[]{(byte) i});
    }

    public static String writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        byte[] bArr = new byte[numberOfTrailingZeros];
        for (int i = numberOfTrailingZeros - 1; i >= 0; i--) {
            bArr[i] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        try {
            return URLEncoder.encode(new String(bArr), "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String writeUtf8CodePoint(int i) {
        byte[] bArr;
        byte[] bArr2;
        if (i < 128) {
            bArr2 = new byte[]{(byte) i};
        } else {
            if (i < 2048) {
                bArr = new byte[]{(byte) ((i >> 6) | 192), (byte) ((i & 63) | 128)};
            } else if (i < 65536) {
                if (i >= 55296 && i <= 57343) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                }
                bArr = new byte[]{(byte) ((i >> 12) | 224), (byte) (((i >> 6) & 63) | 128), (byte) ((i & 63) | 128)};
            } else if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            } else {
                bArr = new byte[]{(byte) ((i >> 18) | 240), (byte) (((i >> 12) & 63) | 128), (byte) (((i >> 6) & 63) | 128), (byte) ((i & 63) | 128)};
            }
            bArr2 = bArr;
        }
        return new String(bArr2);
    }

    public static byte[] writeUtf8CodePoint2(int i) {
        byte[] bArr;
        if (i < 128) {
            return new byte[]{(byte) i};
        }
        if (i < 2048) {
            bArr = new byte[]{(byte) ((i >> 6) | 192), (byte) ((i & 63) | 128)};
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
            bArr = new byte[]{(byte) ((i >> 12) | 224), (byte) (((i >> 6) & 63) | 128), (byte) ((i & 63) | 128)};
        } else if (i > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        } else {
            bArr = new byte[]{(byte) ((i >> 18) | 240), (byte) (((i >> 12) & 63) | 128), (byte) (((i >> 6) & 63) | 128), (byte) ((i & 63) | 128)};
        }
        return bArr;
    }

    public static int delimiterOffset(String str, int i, int i2, char c2) {
        while (i < i2) {
            if (str.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i2;
    }
}
