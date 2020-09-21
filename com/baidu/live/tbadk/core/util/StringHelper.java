package com.baidu.live.tbadk.core.util;

import android.support.media.ExifInterface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdStringHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.games.utils.so.SoUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes4.dex */
public class StringHelper extends BdStringHelper {
    public static final String STRING_MORE = "...";
    private static long MS_TO_SEC = 1000;
    private static long MS_TO_MIN = MS_TO_SEC * 60;
    public static long MS_TO_HOUR = MS_TO_MIN * 60;
    private static long MS_TO_DAY = MS_TO_HOUR * 24;
    private static float SIZE_FLOAT_M = 1048576.0f;
    private static float SIZE_FLOAT_K = 1024.0f;
    private static String HOUR_BEFORE = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_time_hour_before);
    private static String MIN_BEFORE = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_time_min_before);
    private static String SEC_BEFORE = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_time_sec_before);
    private static String TIME_DAY = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_day);
    private static String TIME_HOUR = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_time_hour);
    private static String TIME_MINUTE = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_time_minute);
    private static String TIME_SECOND = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_time_second);
    private static final SimpleDateFormat FORMATE_DATE_SECOND = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat FORMATE_DATE_SECOND_CHINESE = new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
    private static Date date = new Date();

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        if (timeZone != null) {
            FORMATE_DATE_ALL.setTimeZone(timeZone);
            FORMATE_DATE_YEAR.setTimeZone(timeZone);
            FORMATE_DATE_TIME.setTimeZone(timeZone);
            FORMATE_DATE_MOUTH.setTimeZone(timeZone);
            FORMATE_DATE_MOUTH_TIME.setTimeZone(timeZone);
            FORMATE_DATE_DAY.setTimeZone(timeZone);
            FORMATE_DATE_DAY_WEEK.setTimeZone(timeZone);
            FORMATE_DATE_DAY_1.setTimeZone(timeZone);
            FORMATE_DATE_MS.setTimeZone(timeZone);
            FORMATE_DATE_DAY_NO_YEAR.setTimeZone(timeZone);
        }
    }

    public static String formatSecondsTime(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        sb.setLength(0);
        return i5 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public static String formatSecondsTime(long j) {
        long j2 = j % 60;
        long j3 = (j / 60) % 60;
        long j4 = j / 3600;
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        sb.setLength(0);
        return j4 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)).toString() : formatter.format("%02d:%02d", Long.valueOf(j3), Long.valueOf(j2)).toString();
    }

    public static String formatSecondsTimes(long j) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        sb.setLength(0);
        return formatter.format("%02d:%02d:%02d", Long.valueOf(j / 3600), Long.valueOf((j / 60) % 60), Long.valueOf(j % 60)).toString();
    }

    public static String getDateWeek(Date date2) {
        String format;
        synchronized (FORMATE_DATE_DAY_WEEK) {
            format = FORMATE_DATE_DAY_WEEK.format(date2);
        }
        return format;
    }

    public static String getDateStringDay1(Date date2) {
        String format;
        synchronized (FORMATE_DATE_DAY_1) {
            format = FORMATE_DATE_DAY_1.format(date2);
        }
        return format;
    }

    public static String getCurrentString() {
        String format;
        Date date2 = new Date();
        synchronized (FORMATE_DATE_MS) {
            format = FORMATE_DATE_MS.format(date2);
        }
        return format;
    }

    public static String getCurrentTimeZoneSecond() {
        String format;
        Date date2 = new Date();
        synchronized (FORMATE_DATE_SECOND) {
            format = FORMATE_DATE_SECOND.format(date2);
        }
        return format;
    }

    public static String formatDayOrHourTime(long j) {
        int i = (int) (j / BdKVCache.MILLS_1Hour);
        if (i >= 24) {
            return ((i / 24) + 1) + TIME_DAY;
        }
        return (i + 1) + TIME_HOUR;
    }

    public static String getCurrentTimeZoneDay() {
        String format;
        Date date2 = new Date();
        synchronized (FORMATE_DATE_DAY) {
            format = FORMATE_DATE_DAY.format(date2);
        }
        return format;
    }

    public static String getWeekString(int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        switch (calendar.get(7)) {
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
                return "周";
        }
    }

    public static int getyyyyMMddTimeForNow() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(5) + 0 + (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100);
    }

    public static String getPostTimeString(Date date2) {
        return date2 == null ? "" : getPostTimeString(new Date(), date2);
    }

    public static String getPostTimeString(Date date2, Date date3) {
        if (date3 == null) {
            return "";
        }
        int day = date2.getDay() - date3.getDay();
        long time = date2.getTime() - date3.getTime();
        if (time < 0) {
            if (time > -120000) {
                return "刚刚";
            }
            return getDateStringDay(date3);
        } else if (time >= 30000) {
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
                    return getDateStringHm(date3);
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
            return getDateStringDay(date3);
        } else {
            return "刚刚";
        }
    }

    public static String getChatTimeString(Date date2) {
        return getChatTimeString(new Date(), date2);
    }

    public static String getChatTimeString(Date date2, Date date3) {
        String format;
        String format2;
        if (date3 == null) {
            return "";
        }
        int day = date2.getDay() - date3.getDay();
        long time = date2.getTime() - date3.getTime();
        if (time < 0) {
            if (time > -120000) {
                return "刚刚";
            }
            return getDateStringDay(date3);
        } else if (time >= 30000) {
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
                    return getDateStringHm(date3);
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
            if (date2.getYear() == date3.getYear()) {
                synchronized (FORMATE_DATE_DAY_NO_YEAR) {
                    format2 = FORMATE_DATE_DAY_NO_YEAR.format(date3);
                }
                return format2;
            }
            synchronized (FORMATE_DATE_DAY) {
                format = FORMATE_DATE_DAY.format(date3);
            }
            return format;
        } else {
            return "刚刚";
        }
    }

    public static String getTimeInterval(long j) {
        long abs = Math.abs(System.currentTimeMillis() - (1000 * j));
        if (abs <= 120000) {
            return "刚刚";
        }
        if (abs >= Long.MAX_VALUE) {
            return "一个月前";
        }
        if (abs / MS_TO_DAY != 0) {
            if (abs / MS_TO_DAY > 30) {
                return "一个月前";
            }
            return (abs / MS_TO_DAY) + "天前";
        } else if (abs / MS_TO_HOUR != 0) {
            return (abs / MS_TO_HOUR) + "小时前";
        } else {
            return (abs / MS_TO_MIN) + "分钟前";
        }
    }

    public static String getPostTimeInterval(long j) {
        long abs = Math.abs(System.currentTimeMillis() - (1000 * j));
        if (abs <= 120000) {
            return "刚刚";
        }
        if (abs >= Long.MAX_VALUE || abs / MS_TO_DAY != 0) {
            return "";
        }
        if (abs / MS_TO_HOUR != 0) {
            return (abs / MS_TO_HOUR) + "小时前";
        }
        return (abs / MS_TO_MIN) + "分钟前";
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

    public static String getHighLightString(String str, String str2) {
        String str3;
        Exception exc;
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (StringUtils.isNull(str2)) {
            str2 = "#007bd1";
        }
        try {
            String replaceAll = str.replaceAll("<em>", "<font color='" + str2 + "'>");
            try {
                return replaceAll.replaceAll("</em>", "</font>");
            } catch (Exception e) {
                str3 = replaceAll;
                exc = e;
                BdLog.e(exc.toString());
                return str3;
            }
        } catch (Exception e2) {
            str3 = null;
            exc = e2;
        }
    }

    private static long[] parseVersion(String str) {
        long[] jArr = new long[3];
        if (str != null) {
            String[] split = str.replace(".", "#").split("#");
            jArr[0] = Long.parseLong(split[0]);
            jArr[1] = Long.parseLong(split[1]);
            jArr[2] = Long.parseLong(split[2]);
        }
        return jArr;
    }

    public static String getFormatAlaLiveTime(long j) {
        String formatAlaLiveTime;
        synchronized (date) {
            date.setTime(j);
            formatAlaLiveTime = getFormatAlaLiveTime(date);
        }
        return formatAlaLiveTime;
    }

    public static String getFormatTime(long j) {
        String formatTime;
        synchronized (date) {
            date.setTime(j);
            formatTime = getFormatTime(date, false);
        }
        return formatTime;
    }

    public static String getFormatTimeShort(long j) {
        String formatTime;
        synchronized (date) {
            date.setTime(j);
            formatTime = getFormatTime(date, true);
        }
        return formatTime;
    }

    private static String getFormatAlaLiveTime(Date date2) {
        if (date2 == null) {
            return "";
        }
        long time = new Date().getTime() - date2.getTime();
        StringBuilder sb = new StringBuilder();
        long j = time / MS_TO_HOUR;
        if (j > 0) {
            sb.append(j + "小时");
        }
        long j2 = time % MS_TO_HOUR;
        if (j2 > 0) {
            long j3 = j2 / MS_TO_MIN;
            if (j3 == 0) {
                j3 = 1;
            }
            sb.append(j3 + "分钟");
        }
        return sb.toString();
    }

    private static String getFormatTime(Date date2, boolean z) {
        if (date2 == null) {
            return "";
        }
        long time = new Date().getTime() - date2.getTime();
        if (time < MS_TO_DAY && time > 0) {
            if (time < MS_TO_HOUR) {
                if (time < MS_TO_MIN) {
                    long j = time / MS_TO_SEC;
                    if (j == 0) {
                        j = 1;
                    }
                    return String.valueOf(j) + SEC_BEFORE;
                }
                return String.valueOf(time / MS_TO_MIN) + MIN_BEFORE;
            }
            return String.valueOf(time / MS_TO_HOUR) + HOUR_BEFORE;
        } else if (z) {
            return getDateStringDayNoYear(date2);
        } else {
            return getDateStringDay(date2);
        }
    }

    public static String getDateStringDayNoYear(Date date2) {
        String format;
        synchronized (FORMATE_DATE_DAY_NO_YEAR) {
            format = FORMATE_DATE_DAY_NO_YEAR.format(date2);
        }
        return format;
    }

    public static String getTimeSpace(long j) {
        if (j <= 0) {
            return "1秒";
        }
        if (j < MS_TO_DAY) {
            if (j < MS_TO_HOUR) {
                if (j < MS_TO_MIN) {
                    long j2 = j / MS_TO_SEC;
                    if (j2 == 0) {
                        j2 = 1;
                    }
                    return String.valueOf(j2) + TIME_SECOND;
                }
                return String.valueOf(j / MS_TO_MIN) + TIME_MINUTE;
            }
            return String.valueOf(j / MS_TO_HOUR) + TIME_HOUR;
        }
        return String.valueOf(j / MS_TO_DAY) + TIME_DAY;
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

    public static String showTimeString(long j) {
        String valueOf;
        Date date2 = new Date(j);
        if (date2.getMinutes() < 10) {
            valueOf = "0" + date2.getMinutes();
        } else {
            valueOf = String.valueOf(date2.getMinutes());
        }
        return date2.getHours() > 12 ? TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_time_show_afternoon, new Object[]{String.valueOf(date2.getHours() - 12), valueOf}) : date2.getHours() == 12 ? TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_time_show_afternoon, new Object[]{String.valueOf(date2.getHours()), valueOf}) : date2.getHours() == 0 ? TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_time_show_morning, new Object[]{String.valueOf(12), valueOf}) : TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_time_show_morning, new Object[]{String.valueOf(date2.getHours()), valueOf});
    }

    @Deprecated
    public static String numFormat(int i) {
        if (i > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(i / 10000.0f));
        }
        if (i < 0) {
            return "0";
        }
        return "" + i;
    }

    public static String numOver1000(int i) {
        if (i > 1000) {
            return "999+";
        }
        if (i < 0) {
            return "0";
        }
        return "" + i;
    }

    public static String numberUniformFormat(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 10000000) {
            float f = ((float) (j / 1000)) / 10.0f;
            if (f % 1.0f == 0.0f) {
                return ((int) f) + "万";
            }
            return f + "万";
        }
        float f2 = ((float) (j / TimeUtils.NANOS_PER_MS)) / 10.0f;
        if (f2 % 1.0f == 0.0f) {
            return ((int) f2) + "千万";
        }
        return f2 + "千万";
    }

    public static String longNumFormatOver9999wanDoublePoint(double d) {
        if (d < 0.0d) {
            return "0";
        }
        if (d > 9.999E7d) {
            return "9999万+";
        }
        if (d > 9999.0d) {
            return new DecimalFormat("#0.00").format(((float) d) / 10000.0f) + "万";
        }
        return new DecimalFormat("#0.00").format(d);
    }

    public static String longNumFormatOver9999wanOnePoint(long j) {
        if (j < 0) {
            return "0";
        }
        if (j > 99990000) {
            return "9999万+";
        }
        if (j > 9999) {
            return new DecimalFormat("#0.0").format(((float) j) / 10000.0f) + "万";
        }
        return "" + j;
    }

    public static String numberUniform(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 9999000.0d) {
            float f = ((float) (j / 1000)) / 10.0f;
            if (f % 1.0f == 0.0f) {
                return ((int) f) + "万";
            }
            return f + "万";
        }
        return "999.9万";
    }

    public static String numberUniformOver1000Wan(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 9999000.0d) {
            float f = ((float) (j / 1000)) / 10.0f;
            if (f % 1.0f == 0.0f) {
                return ((int) f) + ExifInterface.LONGITUDE_WEST;
            }
            return f + ExifInterface.LONGITUDE_WEST;
        }
        return "999.9W";
    }

    public static String numberUniformFormatExtra(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 10000000) {
            float f = ((float) (j / 1000)) / 10.0f;
            if (f % 1.0f == 0.0f) {
                return ((int) f) + ExifInterface.LONGITUDE_WEST;
            }
            return f + ExifInterface.LONGITUDE_WEST;
        }
        float f2 = ((float) (j / TimeUtils.NANOS_PER_MS)) / 10.0f;
        if (f2 >= 9999.0f) {
            return "9999KW+";
        }
        if (f2 % 1.0f == 0.0f) {
            return ((int) f2) + "KW";
        }
        return f2 + "KW";
    }

    public static String longNumFormatOver10000wanAdd(long j) {
        if (j > 9990000) {
            return "999W+";
        }
        if (j < 0) {
            return "0";
        }
        return "" + j;
    }

    public static String numFormatOver10000ReturnInt(long j) {
        if (j > 9999) {
            return ((int) (((float) j) / 10000.0f)) + ExifInterface.LONGITUDE_WEST;
        }
        if (j < 0) {
            return "0";
        }
        return "" + j;
    }

    public static String numFormatOver10000(long j) {
        if (j > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(((float) j) / 10000.0f));
        }
        if (j < 0) {
            return "0";
        }
        return "" + j;
    }

    public static String numFormatOverWanNa(long j) {
        if (j > 99990000) {
            return "9999W+";
        }
        if (j >= 10000000) {
            return String.valueOf(j / 10000) + ExifInterface.LONGITUDE_WEST;
        }
        if (j > 10000) {
            return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
        }
        if (j == 10000) {
            return "1W";
        }
        if (j < 0) {
            return "--";
        }
        return "" + j;
    }

    public static String numFormatOverWan(long j) {
        if (j > 99990000) {
            return "9999W+";
        }
        if (j >= 10000000) {
            return String.valueOf(j / 10000) + ExifInterface.LONGITUDE_WEST;
        }
        if (j > 10000) {
            return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
        }
        if (j == 10000) {
            return "1W";
        }
        if (j < 0) {
            return "0";
        }
        return "" + j;
    }

    public static String numFormatOver10000wan(long j) {
        if (j > 9999999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return round + ExifInterface.LONGITUDE_WEST;
        } else if (j < 0) {
            return "0";
        } else {
            return "" + j;
        }
    }

    public static String numFormat9999W(long j) {
        if (j > 9999999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return round >= 9999 ? "9999W+" : j + ExifInterface.LONGITUDE_WEST;
        } else if (j < 0) {
            return "0";
        } else {
            return "" + j;
        }
    }

    public static String longNumFormatOver10000wan(long j) {
        if (j > 9999999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return round + "w+";
        } else if (j < 0) {
            return "0";
        } else {
            return "" + j;
        }
    }

    public static String longNumFormatOver10000(long j) {
        if (j > 9999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return round + ExifInterface.LONGITUDE_WEST;
        } else if (j < 0) {
            return "0";
        } else {
            return "" + j;
        }
    }

    public static String longNumFormatOver(long j) {
        if (j > 9999999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return round + "w+";
        } else if (j < 0) {
            return "0";
        } else {
            return "" + j;
        }
    }

    public static String formatTosepara(int i) {
        return new DecimalFormat("#,###").format(i);
    }

    public static String formatTosepara(long j) {
        return new DecimalFormat("#,###").format(j);
    }

    public static String formatForCharmValue(long j) {
        if (j < 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 100000000) {
            double doubleValue = new BigDecimal((j / 10000.0d) + "").setScale(2, RoundingMode.DOWN).doubleValue();
            if (doubleValue % 1.0d == 0.0d) {
                return ((int) doubleValue) + "万";
            }
            return doubleValue + "万";
        }
        double doubleValue2 = new BigDecimal((j / 1.0E8d) + "").setScale(2, RoundingMode.DOWN).doubleValue();
        if (doubleValue2 % 1.0d == 0.0d) {
            return ((int) doubleValue2) + "亿";
        }
        return doubleValue2 + "亿";
    }

    public static String formatForHeaderDayCharmValue(long j) {
        if (j < 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 10000000) {
            double doubleValue = new BigDecimal(j / 10000.0d).setScale(1, RoundingMode.HALF_UP).doubleValue();
            if (doubleValue == 1000.0d) {
                return "0.1亿";
            }
            return doubleValue + "万";
        }
        return new BigDecimal(j / 1.0E8d).setScale(1, RoundingMode.HALF_UP).doubleValue() + "亿";
    }

    public static String formatForHourRankValue(long j) {
        if (j < 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 10000000) {
            double doubleValue = new BigDecimal(j / 10000.0d).setScale(2, RoundingMode.HALF_UP).doubleValue();
            if (doubleValue == 1000.0d) {
                return "0.1亿";
            }
            return doubleValue + "万";
        }
        return new BigDecimal(j / 1.0E8d).setScale(2, RoundingMode.HALF_UP).doubleValue() + "亿";
    }

    public static String formatForPersonCardCharmValue(long j) {
        if (j < 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 100000000) {
            double doubleValue = new BigDecimal((j / 10000.0d) + "").setScale(2, RoundingMode.DOWN).doubleValue();
            if (doubleValue % 1.0d == 0.0d) {
                return ((int) doubleValue) + "万";
            }
            return doubleValue + "万";
        }
        double doubleValue2 = new BigDecimal((j / 1.0E8d) + "").setScale(2, RoundingMode.DOWN).doubleValue();
        if (doubleValue2 % 1.0d == 0.0d) {
            return ((int) doubleValue2) + "亿";
        }
        return doubleValue2 + "亿";
    }

    public static String[] formatForPersonCardBeanValue(long j) {
        String[] strArr = new String[2];
        if (j < 0) {
            strArr[0] = "0";
        } else if (j < 10000) {
            strArr[0] = j + "";
        } else if (j < 100000000) {
            double doubleValue = new BigDecimal((j / 10000.0d) + "").setScale(1, RoundingMode.HALF_UP).doubleValue();
            if (doubleValue % 1.0d == 0.0d) {
                strArr[0] = ((int) doubleValue) + "";
                strArr[1] = "万";
            } else {
                strArr[0] = doubleValue + "";
                strArr[1] = "万";
            }
        } else {
            double doubleValue2 = new BigDecimal((j / 1.0E8d) + "").setScale(1, RoundingMode.HALF_UP).doubleValue();
            if (doubleValue2 % 1.0d == 0.0d) {
                strArr[0] = ((int) doubleValue2) + "";
                strArr[1] = "亿";
            } else {
                strArr[0] = doubleValue2 + "";
                strArr[1] = "亿";
            }
        }
        return strArr;
    }

    public static String getHourRankCurHourLast(String str) {
        if (str.length() < 2) {
            return "";
        }
        return str.substring(str.length() - 2);
    }

    public static String getHourRankCurHour(String str) {
        String str2 = "";
        if (str.length() >= 2) {
            str2 = str.substring(str.length() - 2);
        }
        if (str2.length() != 2) {
            return "00";
        }
        if (TextUtils.equals(str2, "00")) {
            return SoUtils.SO_EVENT_ID_DEFAULT;
        }
        return str2;
    }

    public static String getHourRankPreHour(String str) {
        long j;
        String str2 = "";
        if (str.length() >= 2) {
            str2 = str.substring(str.length() - 2);
        }
        if (str2.length() != 2) {
            return "00";
        }
        try {
            long longValue = Long.valueOf(str2).longValue();
            if (longValue == 0) {
                j = 23;
            } else {
                j = longValue - 1;
            }
            return j + "";
        } catch (NumberFormatException e) {
            return str;
        }
    }

    public static String getHourRankPreHourTag(String str) {
        String str2 = "";
        if (str.length() >= 2) {
            str2 = str.substring(0, str.length() - 2);
        }
        return str2 + getHourRankPreHour(str);
    }

    public static String getHourRankPreHourString(String str, int i) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHH");
        Date date2 = new Date();
        try {
            date2 = simpleDateFormat.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        date2.setHours(date2.getHours() + i);
        return simpleDateFormat.format(date2);
    }

    public static String formatOverBaiwanNum(long j) {
        float f;
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= 100000000) {
            if (j % 100000000 != 0) {
                return String.format("%.1f", Double.valueOf(((float) j) / 1.0E8f)) + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_yi);
            }
            return (j / 100000000) + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_yi);
        } else if (j >= TimeUtils.NANOS_PER_MS) {
            long j2 = j / 10000;
            if (((float) j) / 10000.0f > ((float) j2)) {
                return String.format("%.1f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan);
            }
            return j2 + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan);
        } else {
            return valueOf;
        }
    }

    public static String longNumFormatOver9999wan(long j) {
        if (j < 0) {
            return "0";
        }
        if (j > 99990000) {
            return "9999W+";
        }
        if (j > 9999) {
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            float f = ((float) j) / 10000.0f;
            if (f < 1000.0f) {
                return decimalFormat.format(f) + ExifInterface.LONGITUDE_WEST;
            }
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return round + ExifInterface.LONGITUDE_WEST;
        }
        return String.valueOf(j);
    }

    public static SpannableString highLightText(String str, String str2, int i, boolean z) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || i <= 0) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        if (TextUtils.isEmpty(str2) || !str.contains(str2)) {
            return spannableString;
        }
        if (z) {
            lastIndexOf = str.indexOf(str2);
        } else {
            lastIndexOf = str.lastIndexOf(str2);
        }
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i)), lastIndexOf, str2.length() + lastIndexOf, 33);
        return spannableString;
    }

    public static SpannableString highLightText(String str, int i, int i2, int i3) {
        if (TextUtils.isEmpty(str) || i3 <= 0) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        if (i < i2 && i < str.length() && str.length() >= i2) {
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i3)), i, i2, 33);
            return spannableString;
        }
        return spannableString;
    }

    public static SpannableString highLightText(String str, String str2, int i) {
        return highLightText(str, str2, i, true);
    }

    public static long string2long(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String long2String(long j, String str) {
        Date date2;
        if (String.valueOf(j).length() == 10) {
            date2 = new Date(1000 * j);
        } else {
            date2 = new Date(j);
        }
        return new SimpleDateFormat(str).format(date2);
    }

    public static String forceLToR(String str) {
        return isEmpty(str) ? "" : "\u202d" + str + "\u202c";
    }

    public static SpannableStringBuilder forceLToR(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder == null ? new SpannableStringBuilder("") : new SpannableStringBuilder("\u202d").append((CharSequence) spannableStringBuilder).append((CharSequence) "\u202c");
    }

    public static String getNegativeInfinity() {
        return "-∞";
    }

    public static String cutStringWithSuffix(String str, int i, String str2) {
        if (str != null && i >= 0 && str.length() > i) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0, i));
            if (str2 == null) {
                sb.append("");
            } else {
                sb.append(str2);
            }
            return sb.toString();
        }
        return str;
    }

    public static String cutStringWithEllipsisNew(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (i > 0) {
            try {
                if (str.codePointCount(0, str.length()) > i) {
                    return str.substring(0, str.offsetByCodePoints(0, i - 1)) + STRING_MORE;
                }
                return str;
            } catch (Throwable th) {
                BdLog.e(th);
                return str;
            }
        }
        return str;
    }

    @Deprecated
    public static String cutStringWithEllipsis(String str, int i) {
        return (str == null || i < 0 || str.length() == i) ? str : cutStringWithSuffix(str, i - 1, STRING_MORE);
    }

    public static String cutChineseAndEnglishWithSuffix(String str, int i, String str2) {
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
        if (i2 + 1 < length) {
            if (str2 == null) {
                str2 = "";
            }
            return str.substring(0, i2 + 1) + str2;
        }
        return str;
    }

    public static String subString(String str, int i) {
        int i2 = 0;
        if (str == null || i <= 0) {
            return String.valueOf("");
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (isChinese(charAt)) {
                i2 += 2;
            } else {
                i2++;
            }
            if (i2 > i) {
                break;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static int getChineseAndEnglishLength(String str) {
        int i = 0;
        if (str != null) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (isChinese(str.charAt(i2))) {
                    i += 2;
                } else {
                    i++;
                }
            }
        }
        return i;
    }

    public static String cutForumNameWithSuffix(String str, int i, String str2) {
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
        if (i2 + 1 < length) {
            if (str2 == null) {
                str2 = "";
            }
            if (i3 + 2 < i) {
                return str.substring(0, i2 + 1) + str2;
            }
            return str.substring(0, i2) + str2;
        }
        return str;
    }

    public static String getFormatSize(long j) {
        return ((float) j) >= SIZE_FLOAT_M ? String.format(Locale.getDefault(), "%.1fM", Float.valueOf(((float) j) / SIZE_FLOAT_M)) : ((float) j) >= SIZE_FLOAT_K / 10.0f ? String.format(Locale.getDefault(), "%.1fK", Float.valueOf(((float) j) / SIZE_FLOAT_K)) : TbadkCoreApplication.getInst().getString(a.i.sdk_less_than_zero_dot_one_k);
    }

    public static int getRealSize(String str) {
        int i = 0;
        if (str != null && str.length() > 0) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (isChinese(str.charAt(i2))) {
                    i += 2;
                } else {
                    i++;
                }
            }
        }
        return i;
    }

    public static int getRealSize2(String str) {
        byte[] bytes;
        int i = 0;
        if (str != null && (bytes = str.getBytes()) != null) {
            int length = bytes.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = bytes[i2] & 255;
                if (i3 >= 252) {
                    i2 += 6;
                    i += 2;
                } else if (i3 >= 248) {
                    i2 += 5;
                    i += 2;
                } else if (i3 >= 240) {
                    i2 += 4;
                    i += 2;
                } else if (i3 >= 224) {
                    i2 += 3;
                    i += 2;
                } else if (i3 >= 192) {
                    i2 += 2;
                    i += 2;
                } else {
                    i2++;
                    i++;
                }
            }
        }
        return i;
    }

    public static String subString2(String str, int i) {
        int i2;
        if (str == null || i < 0) {
            return null;
        }
        byte[] bytes = str.getBytes();
        if (bytes == null) {
            return null;
        }
        int length = bytes.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = bytes[i3] & 255;
            if (i5 >= 252) {
                i4 += 2;
                i2 = 6;
            } else if (i5 >= 248) {
                i4 += 2;
                i2 = 5;
            } else if (i5 >= 240) {
                i4 += 2;
                i2 = 4;
            } else if (i5 >= 224) {
                i4 += 2;
                i2 = 3;
            } else if (i5 >= 192) {
                i4 += 2;
                i2 = 2;
            } else {
                i4++;
                i2 = 1;
            }
            if (i4 >= i) {
                byte[] bArr = new byte[i2 + i3];
                System.arraycopy(bytes, 0, bArr, 0, bArr.length);
                return new String(bArr);
            }
            i3 = i2 + i3;
        }
        return str;
    }

    public static String formatNumForTdouDisPlay(long j) {
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= 100000000) {
            if (j % 100000000 != 0) {
                double d = ((float) j) / 1.0E8f;
                double d2 = j / 100000000;
                if (j % 100000000 > 999999.0d) {
                    return String.format("%.2f", Double.valueOf(d)) + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_yi);
                }
                return d2 + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_yi);
            }
            return (j / 100000000) + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_yi);
        } else if (j >= TimeUtils.NANOS_PER_MS) {
            float f = ((float) j) / 10000.0f;
            long j2 = j / 10000;
            if (j % TimeUtils.NANOS_PER_MS > 999) {
                return String.format("%.2f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan);
            }
            return j2 + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan);
        } else {
            return valueOf;
        }
    }

    public static String formatGiftNumForTDouDisPlay(long j) {
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= 100000000) {
            if (j % 100000000 != 0) {
                double d = ((float) j) / 1.0E8f;
                double d2 = j / 100000000;
                if (j % 100000000 > 999999.0d) {
                    return String.format("%.2f", Double.valueOf(d)) + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_yi);
                }
                return d2 + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_yi);
            }
            return (j / 100000000) + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_yi);
        } else if (j >= 10000000) {
            float f = ((float) j) / 10000.0f;
            long j2 = j / 10000;
            if (j % 10000000 > 999) {
                return String.format("%.2f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan);
            }
            return j2 + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan);
        } else {
            return valueOf;
        }
    }

    public static String getFixedText(String str, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        double d = 0.0d;
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || (charAt >= '0' && charAt <= '9'))) {
                d += 0.5d;
            } else {
                d += 1.0d;
            }
            if (d <= i) {
                sb.append(charAt);
                i2++;
            } else if (z) {
                return getFixedText(sb.toString(), i - 1, false) + STRING_MORE;
            }
        }
        return sb.toString();
    }

    public static String getChineseFormatTimeString(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (FORMATE_DATE_SECOND_CHINESE) {
            format = FORMATE_DATE_SECOND_CHINESE.format(date2);
        }
        return format;
    }

    public static boolean equals(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static String getYearBytime(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return String.valueOf(calendar.get(1));
    }

    public static String getChineseYearBytime(long j) {
        return getYearBytime(j) + "年";
    }

    public static String getDateBytime(long j) {
        int date2 = new Date(j).getDate();
        return date2 < 10 ? "0" + String.valueOf(date2) : String.valueOf(date2);
    }

    public static String getChineseMonthBytime(long j) {
        switch (new Date(j).getMonth() + 1) {
            case 1:
                return "一月";
            case 2:
                return "二月";
            case 3:
                return "三月";
            case 4:
                return "四月";
            case 5:
                return "五月";
            case 6:
                return "六月";
            case 7:
                return "七月";
            case 8:
                return "八月";
            case 9:
                return "九月";
            case 10:
                return "十月";
            case 11:
                return "十一月";
            case 12:
                return "十二月";
            default:
                return "";
        }
    }

    public static boolean isTaday(long j) {
        Time time = new Time();
        time.set(j);
        int i = time.year;
        int i2 = time.month;
        int i3 = time.monthDay;
        time.set(System.currentTimeMillis());
        return i == time.year && i2 == time.month && i3 == time.monthDay;
    }

    public static String getUserDescByGender(int i) {
        switch (i) {
            case 1:
                return TbadkCoreApplication.getInst().getContext().getString(a.i.sdk_he);
            case 2:
                return TbadkCoreApplication.getInst().getContext().getString(a.i.sdk_she);
            default:
                return TbadkCoreApplication.getInst().getContext().getString(a.i.sdk_he);
        }
    }

    public static String trim(String str) {
        return str != null ? str.trim() : "";
    }

    public static String stringForVideoTime(int i) {
        if (i < 1000) {
            i = 1000;
        }
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        sb.setLength(0);
        return i5 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public static String cutHotTopicShow(String str, int i, String str2) {
        if (str == null || i <= 0) {
            return String.valueOf("");
        }
        int length = str.length();
        if (str.indexOf("#") != 0 || str.lastIndexOf("#") != length - 1) {
            return cutChineseAndEnglishWithSuffix(str, i, str2);
        }
        String replaceAll = str.replaceAll("#", "");
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (isChinese(replaceAll.charAt(i2))) {
                i3 += 2;
            } else {
                i3++;
            }
            if (i3 >= i) {
                break;
            }
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        if (i2 + 1 < length) {
            if (str2 == null) {
                str2 = "";
            }
            return sb.append("#").append(replaceAll.substring(0, i2 + 1)).append(str2).append("#").toString();
        }
        return sb.append("#").append(replaceAll).append("#").toString();
    }

    public static String formatValue(long j) {
        if (j < 10000) {
            return String.valueOf(j);
        }
        if (j < 100000000) {
            return round((j * 1.0d) / 10000.0d, 1) + "万";
        }
        return round((j * 1.0d) / 1.0E8d, 2) + "亿";
    }

    private static double round(double d, int i) {
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), i, 4).doubleValue();
    }

    public static String formatYuyinValue(long j) {
        String str;
        try {
            if (j < 10000) {
                str = String.valueOf(j);
            } else if (j < 100000000) {
                str = stripTrailingZeros(roundDown((j * 1.0d) / 10000.0d, 1)) + "万";
            } else {
                str = stripTrailingZeros(roundDown((j * 1.0d) / 1.0E8d, 1)) + "亿";
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    private static String stripTrailingZeros(double d) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
        return bigDecimal.toString().contains(".") ? bigDecimal.stripTrailingZeros().stripTrailingZeros().toPlainString() : bigDecimal.toString();
    }

    private static double roundDown(double d, int i) {
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), i, 1).doubleValue();
    }
}
