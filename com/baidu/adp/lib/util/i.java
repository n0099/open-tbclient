package com.baidu.adp.lib.util;

import android.annotation.SuppressLint;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.Character;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes.dex */
public class i {
    protected static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    protected static SimpleDateFormat b = new SimpleDateFormat("yyyy年");
    protected static SimpleDateFormat c = new SimpleDateFormat("HH:mm");
    protected static SimpleDateFormat d = new SimpleDateFormat("M月d日");
    protected static SimpleDateFormat e = new SimpleDateFormat("M月d日 HH:mm");
    protected static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    protected static SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd E");
    protected static SimpleDateFormat h = new SimpleDateFormat("yy-M-d");
    protected static SimpleDateFormat i = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    protected static SimpleDateFormat j = new SimpleDateFormat("MM-dd");
    private static final char[] k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] l = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] m = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a(CharSequence charSequence, String str) {
        if (charSequence instanceof String) {
            return (String) charSequence;
        }
        return charSequence != null ? charSequence.toString() : str;
    }

    public static String a(Date date) {
        String format;
        synchronized (e) {
            format = e.format(date);
        }
        return format;
    }

    public static String b(Date date) {
        String format;
        synchronized (c) {
            format = c.format(date);
        }
        return format;
    }

    public static String c(Date date) {
        String format;
        synchronized (d) {
            format = d.format(date);
        }
        return format;
    }

    public static String d(Date date) {
        String format;
        synchronized (f) {
            format = f.format(date);
        }
        return format;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(k[(bArr[i2] & 240) >>> 4]);
            sb.append(k[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    public static String a(InputStream inputStream) {
        String str = null;
        if (inputStream != null) {
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                str = a(messageDigest.digest());
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            } finally {
                m.a(inputStream);
            }
        }
        return str;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(new ByteArrayInputStream(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            return null;
        }
    }

    public static boolean a(char c2) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c2);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean b(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0 || str.equals("null");
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(String str, int i2) {
        if (str == null || i2 <= 0) {
            return String.valueOf("");
        }
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (a(str.charAt(i3))) {
                i4 += 2;
            } else {
                i4++;
            }
            if (i4 >= i2) {
                break;
            }
            i3++;
        }
        if (i3 < length) {
            return String.valueOf(str.substring(0, i3 + 1)) + "...";
        }
        return str;
    }

    public static String b(byte[] bArr) {
        int length = bArr.length;
        int i2 = 0;
        StringBuilder sb = new StringBuilder(length / 2);
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i3 == length) {
                sb.append(l[i4 >>> 2]);
                sb.append(l[(i4 & 3) << 4]);
                sb.append("==");
                break;
            }
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 == length) {
                sb.append(l[i4 >>> 2]);
                sb.append(l[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                sb.append(l[(i6 & 15) << 2]);
                sb.append("=");
                break;
            }
            i2 = i5 + 1;
            int i7 = bArr[i5] & 255;
            sb.append(l[i4 >>> 2]);
            sb.append(l[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
            sb.append(l[((i6 & 15) << 2) | ((i7 & 192) >>> 6)]);
            sb.append(l[i7 & 63]);
        }
        return sb.toString();
    }

    public static String a(String... strArr) {
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
