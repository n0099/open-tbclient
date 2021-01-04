package com.baidu.down.utils;

import java.io.UnsupportedEncodingException;
import java.net.IDN;
import java.net.URLEncoder;
import java.util.Locale;
/* loaded from: classes15.dex */
public class HttpUrlHelperUtil {
    static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, com.baidu.android.imsdk.internal.Constants.SHORT_PING_CMD_TYPE, 102};

    public static int delimiterOffset(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    public static int delimiterOffset(String str, int i, int i2, char c) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == c) {
                return i3;
            }
        }
        return i2;
    }

    public static int skipLeadingAsciiWhitespace(String str, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                default:
                    return i3;
            }
        }
        return i2;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                default:
                    return i3 + 1;
            }
        }
        return i;
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
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static boolean containsInvalidHostnameAsciiCodes(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return true;
            }
            if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String writeByte(int i) {
        return new String(new byte[]{(byte) i});
    }

    public static String writeUtf8CodePoint(int i) {
        byte[] bArr;
        if (i < 128) {
            bArr = new byte[]{(byte) i};
        } else if (i < 2048) {
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
        return new String(bArr);
    }

    public static byte[] writeUtf8CodePoint2(int i) {
        if (i < 128) {
            return new byte[]{(byte) i};
        }
        if (i < 2048) {
            return new byte[]{(byte) ((i >> 6) | 192), (byte) ((i & 63) | 128)};
        }
        if (i < 65536) {
            if (i < 55296 || i > 57343) {
                return new byte[]{(byte) ((i >> 12) | 224), (byte) (((i >> 6) & 63) | 128), (byte) ((i & 63) | 128)};
            }
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        } else if (i <= 1114111) {
            return new byte[]{(byte) ((i >> 18) | 240), (byte) (((i >> 12) & 63) | 128), (byte) (((i >> 6) & 63) | 128), (byte) ((i & 63) | 128)};
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
    }

    public static int decodeHexDigit(char c) {
        if (c < '0' || c > '9') {
            if (c < 'a' || c > 'f') {
                if (c < 'A' || c > 'F') {
                    return -1;
                }
                return (c - 'A') + 10;
            }
            return (c - 'a') + 10;
        }
        return c - '0';
    }
}
