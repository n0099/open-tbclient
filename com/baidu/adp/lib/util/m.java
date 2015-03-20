package com.baidu.adp.lib.util;

import java.lang.Character;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class m {
    protected static SimpleDateFormat yC = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    protected static SimpleDateFormat yD = new SimpleDateFormat("yyyy年");
    protected static SimpleDateFormat yE = new SimpleDateFormat("HH:mm");
    protected static SimpleDateFormat yF = new SimpleDateFormat("M月d日");
    protected static SimpleDateFormat yG = new SimpleDateFormat("M月d日 HH:mm");
    protected static SimpleDateFormat yH = new SimpleDateFormat("yyyy-MM-dd");
    protected static SimpleDateFormat yI = new SimpleDateFormat("yyyy-MM-dd E");
    protected static SimpleDateFormat yJ = new SimpleDateFormat("yy-M-d");
    protected static SimpleDateFormat yK = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    protected static SimpleDateFormat yL = new SimpleDateFormat("MM-dd");

    public static String a(CharSequence charSequence, String str) {
        if (charSequence instanceof String) {
            return (String) charSequence;
        }
        return charSequence != null ? charSequence.toString() : str;
    }

    public static String a(Date date) {
        String format;
        synchronized (yG) {
            format = yG.format(date);
        }
        return format;
    }

    public static String b(Date date) {
        String format;
        synchronized (yE) {
            format = yE.format(date);
        }
        return format;
    }

    public static String c(Date date) {
        String format;
        synchronized (yF) {
            format = yF.format(date);
        }
        return format;
    }

    public static String d(Date date) {
        String format;
        synchronized (yH) {
            format = yH.format(date);
        }
        return format;
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean aK(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.equals("null");
    }

    public static boolean aL(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String aM(String str) {
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

    public static String aN(String str) {
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
