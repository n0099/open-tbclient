package com.baidu.ala.adp.lib.util;

import android.annotation.SuppressLint;
import android.graphics.Color;
import com.baidu.live.tbadk.core.util.StringHelper;
import java.lang.Character;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes15.dex */
public class BdStringHelper {
    protected static SimpleDateFormat FORMATE_DATE_ALL = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    protected static SimpleDateFormat FORMATE_DATE_YEAR = new SimpleDateFormat("yyyy年");
    protected static SimpleDateFormat FORMATE_DATE_TIME = new SimpleDateFormat("HH:mm");
    protected static SimpleDateFormat FORMATE_DATE_MOUTH = new SimpleDateFormat("M月d日");
    protected static SimpleDateFormat FORMATE_DATE_MOUTH_TIME = new SimpleDateFormat("M月d日 HH:mm");
    protected static SimpleDateFormat FORMATE_DATE_DAY = new SimpleDateFormat("yyyy-MM-dd");
    protected static SimpleDateFormat FORMATE_DATE_DAY_WEEK = new SimpleDateFormat("yyyy-MM-dd E");
    protected static SimpleDateFormat FORMATE_DATE_DAY_1 = new SimpleDateFormat("yy-M-d");
    protected static SimpleDateFormat FORMATE_DATE_MS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    protected static SimpleDateFormat FORMATE_DATE_DAY_NO_YEAR = new SimpleDateFormat("MM-dd");
    protected static SimpleDateFormat FORMATE_DATE_YMD_HM = new SimpleDateFormat("yyyy/MM/dd HH:mm");

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

    public static String getDateStringYear(Date date) {
        String format;
        synchronized (FORMATE_DATE_YEAR) {
            format = FORMATE_DATE_YEAR.format(date);
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

    public static String getCurrentString() {
        String format;
        Date date = new Date();
        synchronized (FORMATE_DATE_ALL) {
            format = FORMATE_DATE_ALL.format(date);
        }
        return format;
    }

    public static String getYMDhmFormatTime(long j) {
        String format;
        Date date = new Date(j);
        synchronized (FORMATE_DATE_YMD_HM) {
            format = FORMATE_DATE_YMD_HM.format(date);
        }
        return format;
    }

    private static String getHourShow(int i) {
        String valueOf;
        String str;
        if (i < 10) {
            valueOf = "0" + i;
        } else {
            valueOf = String.valueOf(i);
        }
        if (i >= 0 && i < 6) {
            str = "凌晨";
        } else if (i >= 6 && i < 9) {
            str = "早晨";
        } else if (i >= 9 && i < 12) {
            str = "上午";
        } else if (i >= 12 && i < 14) {
            str = "中午";
        } else if (i >= 14 && i < 18) {
            str = "下午";
        } else if (i >= 18 && i < 24) {
            str = "晚上";
        } else {
            str = "";
        }
        return str + valueOf;
    }

    private static String getMinuteShow(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }

    private static String getWeekShow(int i) {
        switch (i) {
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
            default:
                return "";
        }
    }

    public static String getMicroMsgTime(long j, long j2) {
        if (j2 == 0) {
            j2 = System.currentTimeMillis() / 1000;
        }
        Calendar gregorianCalendar = GregorianCalendar.getInstance();
        gregorianCalendar.setTimeInMillis(1000 * j);
        int i = gregorianCalendar.get(1);
        int i2 = gregorianCalendar.get(2) + 1;
        int i3 = gregorianCalendar.get(5);
        int i4 = gregorianCalendar.get(11);
        int i5 = gregorianCalendar.get(12);
        int i6 = gregorianCalendar.get(3);
        int i7 = gregorianCalendar.get(7);
        gregorianCalendar.setTimeInMillis(1000 * j2);
        int i8 = gregorianCalendar.get(1);
        int i9 = gregorianCalendar.get(2) + 1;
        int i10 = gregorianCalendar.get(5);
        int i11 = gregorianCalendar.get(3);
        String hourShow = getHourShow(i4);
        String minuteShow = getMinuteShow(i5);
        if (j > j2) {
            if (i3 == i10) {
                return hourShow + ":" + minuteShow;
            }
            return i2 + "月" + i3 + "日 " + hourShow + ":" + minuteShow;
        } else if (i < i8) {
            return i + "年" + i2 + "月" + i3 + "日 " + hourShow + ":" + minuteShow;
        } else {
            if (i2 < i9) {
                return i2 + "月" + i3 + "日 " + hourShow + ":" + minuteShow;
            }
            if (i3 < i10) {
                if (i6 < i11) {
                    return i2 + "月" + i3 + "日 " + hourShow + ":" + minuteShow;
                }
                return getWeekShow(i7) + " " + hourShow + ":" + minuteShow;
            }
            return hourShow + ":" + minuteShow;
        }
    }

    public static String getTimeString(long j) {
        String format;
        Date date = new Date(j);
        synchronized (FORMATE_DATE_ALL) {
            format = FORMATE_DATE_ALL.format(date);
        }
        return format;
    }

    public static String getTimeString(Date date) {
        if (date == null) {
            return "";
        }
        Date date2 = new Date();
        if (date2.getYear() == date.getYear()) {
            if (date2.getMonth() == date.getMonth() && date2.getDate() == date.getDate()) {
                return getDateStringHm(date);
            }
            return getDateStringMouth(date);
        }
        return getDateStringYear(date);
    }

    public static String getTimeString2(Date date) {
        if (date == null) {
            return "";
        }
        Date date2 = new Date();
        if (date2.getMonth() == date.getMonth() && date2.getDate() == date.getDate()) {
            return getDateStringHm(date);
        }
        return getDateStringDay(date);
    }

    public static String getTimeString3(Date date) {
        if (date == null) {
            return "";
        }
        String timeStringWithinMonth = getTimeStringWithinMonth(date);
        return timeStringWithinMonth == null ? getDateStringDay(date) : timeStringWithinMonth;
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

    public static boolean contentChinese(String str) {
        if (str == null || str.length() < 1) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (isChinese(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean isAccount(String str) {
        if (Pattern.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\w]+$").matcher(str).matches()) {
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (String.valueOf(str.charAt(i2)).getBytes().length == 1) {
                    i++;
                } else {
                    i += 2;
                }
            }
            return i > 0 && i <= 14;
        }
        return false;
    }

    public static boolean isPassword(String str) {
        int length = str.length();
        return length >= 6 && length <= 14 && str.getBytes().length <= length;
    }

    public static boolean isForumName(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean isMobileNo(String str) {
        return Pattern.compile("1\\d{10}").matcher(str).matches();
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
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < str.length()) {
                if (Integer.toHexString(str.charAt(i2)).length() == 4) {
                    i = i3 + 2;
                } else {
                    i = i3 + 1;
                }
                i2++;
            } else {
                return i3;
            }
        }
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

    public static String getNameFromUrl(String str) {
        try {
            int lastIndexOf = str.lastIndexOf("/");
            int lastIndexOf2 = str.lastIndexOf(".");
            if (lastIndexOf != -1) {
                if (lastIndexOf < lastIndexOf2) {
                    str = str.substring(lastIndexOf, lastIndexOf2);
                } else {
                    str = str.substring(lastIndexOf);
                }
            }
            return str;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public static String getHighLightString(String str, Color color) {
        if (str == null) {
            return "";
        }
        try {
            return str.replaceAll("<em>", "<font color='#007bd1'>").replaceAll("</em>", "</font>");
        } catch (Exception e) {
            BdLog.e(e.toString());
            return null;
        }
    }

    private static long[] parseVersion(String str) {
        long[] jArr = new long[4];
        if (str != null) {
            String[] split = str.replace(".", "#").split("#");
            jArr[0] = Long.parseLong(split[0]);
            jArr[1] = Long.parseLong(split[1]);
            jArr[2] = Long.parseLong(split[2]);
        }
        return jArr;
    }

    public static int compareVersion(String str, String str2) {
        long j = 0;
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        long[] parseVersion = parseVersion(str);
        long[] parseVersion2 = parseVersion(str2);
        long j2 = 0;
        for (int i = 0; i < 3; i++) {
            j2 += parseVersion[i] << (24 - (i * 8));
        }
        for (int i2 = 0; i2 < 3; i2++) {
            j += parseVersion2[i2] << (24 - (i2 * 8));
        }
        if (j2 > j) {
            return 1;
        }
        return j2 == j ? 0 : -1;
    }

    public static String stringFilter(String str) throws PatternSyntaxException {
        return Pattern.compile("[/\\:*?<>|\"\n\t]").matcher(str).replaceAll("").trim();
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
}
