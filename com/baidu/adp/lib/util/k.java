package com.baidu.adp.lib.util;

import java.lang.Character;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class k {
    protected static SimpleDateFormat nc = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    protected static SimpleDateFormat nd = new SimpleDateFormat("yyyy年");
    protected static SimpleDateFormat ne = new SimpleDateFormat("HH:mm");
    protected static SimpleDateFormat nf = new SimpleDateFormat("M月d日");
    protected static SimpleDateFormat ng = new SimpleDateFormat("M月d日 HH:mm");
    protected static SimpleDateFormat nh = new SimpleDateFormat("yyyy-MM-dd");
    protected static SimpleDateFormat ni = new SimpleDateFormat("yyyy-MM-dd E");
    protected static SimpleDateFormat nj = new SimpleDateFormat("yy-M-d");
    protected static SimpleDateFormat nk = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    protected static SimpleDateFormat nl = new SimpleDateFormat("MM-dd");
    private static final char[] nm = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] nn = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a(CharSequence charSequence, String str) {
        if (charSequence instanceof String) {
            return (String) charSequence;
        }
        return charSequence != null ? charSequence.toString() : str;
    }

    public static String a(Date date) {
        String format;
        synchronized (ng) {
            format = ng.format(date);
        }
        return format;
    }

    public static String b(Date date) {
        String format;
        synchronized (ne) {
            format = ne.format(date);
        }
        return format;
    }

    public static String c(Date date) {
        String format;
        synchronized (nf) {
            format = nf.format(date);
        }
        return format;
    }

    public static String d(Date date) {
        String format;
        synchronized (nh) {
            format = nh.format(date);
        }
        return format;
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean aC(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.equals("null");
    }

    public static boolean aD(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String aE(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String aF(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String h(String str, int i) {
        if (str == null || i <= 0) {
            return String.valueOf("");
        }
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (isChinese(str.charAt(i2))) {
                i3 += 2;
            } else {
                i3++;
            }
            if (i3 >= i) {
                break;
            }
            i2++;
        }
        if (i2 < length) {
            return String.valueOf(str.substring(0, i2 + 1)) + "...";
        }
        return str;
    }

    public static String base64Encode(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        StringBuilder sb = new StringBuilder(length / 2);
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                sb.append(nm[i3 >>> 2]);
                sb.append(nm[(i3 & 3) << 4]);
                sb.append("==");
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            if (i4 == length) {
                sb.append(nm[i3 >>> 2]);
                sb.append(nm[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                sb.append(nm[(i5 & 15) << 2]);
                sb.append("=");
                break;
            }
            i = i4 + 1;
            int i6 = bArr[i4] & 255;
            sb.append(nm[i3 >>> 2]);
            sb.append(nm[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
            sb.append(nm[((i5 & 15) << 2) | ((i6 & 192) >>> 6)]);
            sb.append(nm[i6 & 63]);
        }
        return sb.toString();
    }

    public static String e(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
