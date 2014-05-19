package com.baidu.adp.lib.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class StringUtils {
    private static final String TIMEFORMAT = "yyyy-MM-dd HH:mm";
    public static final String lineSeparator = System.getProperty("line.separator");

    public static String SimpleDateFormat(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(TIMEFORMAT).format(date);
    }

    public static String SimpleDateFormat(Date date, String str) {
        if (date == null) {
            return null;
        }
        if (str == null) {
            str = TIMEFORMAT;
        }
        return new SimpleDateFormat(str).format(date);
    }

    public static Date handleDate(String str) {
        return handleDate(str, TIMEFORMAT);
    }

    public static Date handleDate(String str, String str2) {
        if (str2 == null) {
            str2 = TIMEFORMAT;
        }
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isNull(String str) {
        if (str != null && str.trim().length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isNULL(String str) {
        if (str != null) {
            return false;
        }
        return true;
    }

    public static boolean isNull(String str, boolean z) {
        boolean z2 = false;
        if (str == null || str.trim().length() == 0) {
            z2 = true;
        }
        if (z2 || !z || str == null || !str.equalsIgnoreCase("null")) {
            return z2;
        }
        return true;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    private static String unitFormat(int i) {
        if (i >= 0 && i < 10) {
            return "0" + Integer.toString(i);
        }
        return new StringBuilder().append(i).toString();
    }

    public static String translateSecondsToString(int i) {
        if (i <= 0) {
            return "00:00";
        }
        int i2 = i / 60;
        if (i2 < 60) {
            return String.valueOf(unitFormat(i2)) + ":" + unitFormat(i % 60);
        }
        int i3 = i2 / 60;
        if (i3 > 99) {
            return "99:59:59";
        }
        int i4 = i2 % 60;
        return String.valueOf(unitFormat(i3)) + ":" + unitFormat(i4) + ":" + unitFormat((i - (i3 * 3600)) - (i4 * 60));
    }

    public static boolean compareUrlsBeforeQuestionMark(String str, String str2) {
        if (isNull(str) || isNull(str2)) {
            return false;
        }
        int indexOf = str.indexOf(63);
        if (indexOf == -1) {
            return str.equals(str2);
        }
        if (indexOf <= str2.length()) {
            return str.substring(0, indexOf).equals(str2.substring(0, indexOf));
        }
        return false;
    }
}
