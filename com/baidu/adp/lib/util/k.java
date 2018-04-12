package com.baidu.adp.lib.util;

import android.annotation.SuppressLint;
import java.lang.Character;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes.dex */
public class k {
    protected static SimpleDateFormat wW = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    protected static SimpleDateFormat wX = new SimpleDateFormat("yyyy年");
    protected static SimpleDateFormat wY = new SimpleDateFormat("HH:mm");
    protected static SimpleDateFormat wZ = new SimpleDateFormat("M月d日");
    protected static SimpleDateFormat xa = new SimpleDateFormat("M月d日 HH:mm");
    protected static SimpleDateFormat xb = new SimpleDateFormat("yyyy-MM-dd");
    protected static SimpleDateFormat xc = new SimpleDateFormat("yyyy-MM-dd E");
    protected static SimpleDateFormat xd = new SimpleDateFormat("yy-M-d");
    protected static SimpleDateFormat xe = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    protected static SimpleDateFormat xf = new SimpleDateFormat("MM-dd");

    public static String a(CharSequence charSequence, String str) {
        if (charSequence instanceof String) {
            return (String) charSequence;
        }
        return charSequence != null ? charSequence.toString() : str;
    }

    public static String b(Date date) {
        String format;
        synchronized (xa) {
            format = xa.format(date);
        }
        return format;
    }

    public static String c(Date date) {
        String format;
        synchronized (wY) {
            format = wY.format(date);
        }
        return format;
    }

    public static String d(Date date) {
        String format;
        synchronized (wZ) {
            format = wZ.format(date);
        }
        return format;
    }

    public static String e(Date date) {
        String format;
        synchronized (xb) {
            format = xb.format(date);
        }
        return format;
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean aQ(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.equals("null");
    }

    public static boolean aR(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String aS(String str) {
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

    public static String aT(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int aU(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (Integer.toHexString(str.charAt(i2)).length() == 4) {
                i += 2;
            } else {
                i++;
            }
        }
        return i;
    }

    public static String j(String str, int i) {
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
        if (i2 < length - 1) {
            return str.substring(0, i2 + 1) + "...";
        }
        return str;
    }

    public static String j(String... strArr) {
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
