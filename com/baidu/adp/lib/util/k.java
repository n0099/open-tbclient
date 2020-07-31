package com.baidu.adp.lib.util;

import android.annotation.SuppressLint;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import java.lang.Character;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes.dex */
public class k {
    protected static SimpleDateFormat FORMATE_DATE_ALL = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    protected static SimpleDateFormat FORMATE_DATE_YEAR = new SimpleDateFormat("yyyy年");
    protected static SimpleDateFormat FORMATE_DATE_TIME = new SimpleDateFormat("HH:mm");
    protected static SimpleDateFormat FORMATE_DATE_MOUTH = new SimpleDateFormat("M月d日");
    protected static SimpleDateFormat FORMATE_DATE_MOUTH_TIME = new SimpleDateFormat("M月d日 HH:mm");
    protected static SimpleDateFormat FORMATE_DATE_DAY = new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT);
    protected static SimpleDateFormat FORMATE_DATE_DAY_WEEK = new SimpleDateFormat("yyyy-MM-dd E");
    protected static SimpleDateFormat FORMATE_DATE_DAY_1 = new SimpleDateFormat("yy-M-d");
    protected static SimpleDateFormat FORMATE_DATE_MS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    protected static SimpleDateFormat FORMATE_DATE_DAY_NO_YEAR = new SimpleDateFormat("MM-dd");

    public static String charSequence2String(CharSequence charSequence, String str) {
        if (charSequence instanceof String) {
            return (String) charSequence;
        }
        return charSequence != null ? charSequence.toString() : str;
    }

    public static String getDateStringMdHm(Date date) {
        String format;
        synchronized (FORMATE_DATE_MOUTH_TIME) {
            format = FORMATE_DATE_MOUTH_TIME.format(date);
        }
        return format;
    }

    public static String getDateStringHm(Date date) {
        String format;
        synchronized (FORMATE_DATE_TIME) {
            format = FORMATE_DATE_TIME.format(date);
        }
        return format;
    }

    public static String getDateStringMouth(Date date) {
        String format;
        synchronized (FORMATE_DATE_MOUTH) {
            format = FORMATE_DATE_MOUTH.format(date);
        }
        return format;
    }

    public static String getDateStringDay(Date date) {
        String format;
        synchronized (FORMATE_DATE_DAY) {
            format = FORMATE_DATE_DAY.format(date);
        }
        return format;
    }

    public static String getTimeStringNoYear(Date date) {
        String format;
        if (date == null) {
            return "";
        }
        String timeStringWithinMonth = getTimeStringWithinMonth(date);
        if (timeStringWithinMonth == null) {
            synchronized (FORMATE_DATE_DAY_NO_YEAR) {
                format = FORMATE_DATE_DAY_NO_YEAR.format(date);
            }
            return format;
        }
        return timeStringWithinMonth;
    }

    public static String getTimeStringWithinMonth(Date date) {
        Date date2 = new Date();
        int day = date2.getDay() - date.getDay();
        long time = date2.getTime() - date.getTime();
        if (time >= 30000) {
            long j = 30000 * 2;
            if (time < j) {
                return "半分钟前";
            }
            long j2 = j * 60;
            if (time < j2) {
                return String.valueOf((time * 60) / j2) + "分钟前";
            }
            long j3 = j2 * 24;
            if (time < j3) {
                if (day == 0) {
                    return getDateStringHm(date);
                }
                return "1天前";
            }
            long j4 = j3 * 31;
            if (time < j4) {
                return String.valueOf((time * 31) / j4) + "天前";
            }
            if (time < j4 + 86400000) {
                return "1个月前";
            }
            return null;
        }
        return "刚刚";
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean isForumName(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.equals("null");
    }

    public static boolean isEmptyStringAfterTrim(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String getUrlEncode(String str) {
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

    public static String getUrlDecode(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int byteLength(String str) {
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

    public static String cutString(String str, int i) {
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
            return str.substring(0, i2 + 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public static String join(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static boolean y(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
