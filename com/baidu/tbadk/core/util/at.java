package com.baidu.tbadk.core.util;

import android.net.ParseException;
import android.support.media.ExifInterface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class at extends com.baidu.adp.lib.util.k {
    private static long MS_TO_SEC = 1000;
    public static long MS_TO_MIN = MS_TO_SEC * 60;
    public static long MS_TO_HOUR = MS_TO_MIN * 60;
    public static long MS_TO_DAY = MS_TO_HOUR * 24;
    private static float SIZE_FLOAT_M = 1048576.0f;
    private static float SIZE_FLOAT_K = 1024.0f;
    private static String HOUR_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_hour_before);
    private static String MIN_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_min_before);
    private static String SEC_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_sec_before);
    private static String TIME_DAY = TbadkCoreApplication.getInst().getApp().getString(R.string.day);
    private static String TIME_HOUR = TbadkCoreApplication.getInst().getApp().getString(R.string.time_hour);
    private static String TIME_MINUTE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_minute);
    private static String TIME_SECOND = TbadkCoreApplication.getInst().getApp().getString(R.string.time_second);
    private static String ekQ = TbadkCoreApplication.getInst().getApp().getString(R.string.ala_card_create_day);
    private static String ekR = TbadkCoreApplication.getInst().getApp().getString(R.string.ala_card_create_hour);
    private static String ekS = TbadkCoreApplication.getInst().getApp().getString(R.string.ala_card_create_min);
    private static final SimpleDateFormat FORMATE_DATE_SECOND = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat FORMATE_DATE_SECOND_CHINESE = new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
    private static final SimpleDateFormat ekT = new SimpleDateFormat("dd日HH:mm");
    private static final SimpleDateFormat ekU = new SimpleDateFormat("HH:mm");
    private static final SimpleDateFormat ekV = new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT);
    private static final SimpleDateFormat ekW = new SimpleDateFormat("MM-dd HH:mm");
    private static final SimpleDateFormat ekX = new SimpleDateFormat("MM-dd");
    private static final SimpleDateFormat ekY = new SimpleDateFormat("MM月dd日");
    private static final SimpleDateFormat ekZ = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final SimpleDateFormat ela = new SimpleDateFormat("MM-dd HH:mm");
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

    public static String cG(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (ela) {
            format = ela.format(date2);
        }
        return format;
    }

    public static String cH(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (ekZ) {
            format = ekZ.format(date2);
        }
        return format;
    }

    public static String cI(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (ekW) {
            format = ekW.format(date2);
        }
        return format;
    }

    public static String cJ(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (ekX) {
            format = ekX.format(date2);
        }
        return format;
    }

    public static String cK(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (ekY) {
            format = ekY.format(date2);
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

    public static String formatDayOrHourTime(long j) {
        int i = (int) (j / BdKVCache.MILLS_1Hour);
        if (i >= 24) {
            return ((i / 24) + 1) + TIME_DAY;
        }
        return (i + 1) + TIME_HOUR;
    }

    public static String cL(long j) {
        return (((j / BdKVCache.MILLS_1Hour) / 24) + 1) + TIME_DAY;
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

    public static String l(Date date2) {
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

    public static String getFormatTime(long j) {
        String formatTime;
        synchronized (date) {
            date.setTime(j);
            formatTime = getFormatTime(date, false);
        }
        return formatTime;
    }

    public static String cM(long j) {
        String a;
        synchronized (date) {
            date.setTime(j);
            a = a(date, false);
        }
        return a;
    }

    public static String cN(long j) {
        String m;
        synchronized (date) {
            date.setTime(j);
            m = m(date);
        }
        return m;
    }

    public static String cO(long j) {
        String n;
        synchronized (date) {
            date.setTime(j);
            n = n(date);
        }
        return n;
    }

    public static String getFormatTimeShort(long j) {
        String formatTime;
        synchronized (date) {
            date.setTime(j);
            formatTime = getFormatTime(date, true);
        }
        return formatTime;
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

    private static String m(Date date2) {
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
        }
        return TbadkCoreApplication.getInst().getApp().getString(R.string.more_one_day);
    }

    private static String a(Date date2, boolean z) {
        if (date2 == null) {
            return "";
        }
        long time = new Date().getTime() - date2.getTime();
        if (time < MS_TO_DAY && time > 0) {
            if (time < MS_TO_HOUR) {
                if (time < MS_TO_MIN) {
                    return "刚刚";
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

    private static String n(Date date2) {
        if (date2 == null) {
            return "";
        }
        long time = new Date().getTime() - date2.getTime();
        if (time < 0) {
            return "";
        }
        if (time < MS_TO_DAY) {
            if (time < MS_TO_HOUR) {
                if (time < MS_TO_MIN) {
                    return "1" + ekS;
                }
                return String.valueOf(time / MS_TO_MIN) + ekS;
            }
            return String.valueOf(time / MS_TO_HOUR) + ekR;
        }
        return String.valueOf(time / MS_TO_DAY) + ekQ;
    }

    public static boolean Ag(String str) {
        if (str.length() != 10) {
            return false;
        }
        return ekV.format(new Date()).substring(0, 4).equals(str.substring(0, 4));
    }

    public static String o(Date date2) {
        String format;
        synchronized (ekV) {
            format = ekV.format(date2);
        }
        return format;
    }

    public static String getDateStringDayNoYear(Date date2) {
        String format;
        synchronized (FORMATE_DATE_DAY_NO_YEAR) {
            format = FORMATE_DATE_DAY_NO_YEAR.format(date2);
        }
        return format;
    }

    public static String p(Date date2) {
        if (date2 == null) {
            return null;
        }
        String[] strArr = {"宝瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "室女座", "天秤座", "天蝎座", "人马座", "摩羯座"};
        int[] iArr = {20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22};
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date2);
            int i = calendar.get(5);
            int i2 = calendar.get(2);
            if (i < iArr[i2]) {
                i2--;
            }
            if (i2 < 0) {
                i2 = 11;
            }
            if (i2 < 0 || i2 > 11) {
                return null;
            }
            return strArr[i2];
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
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

    public static String cP(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 10000000) {
            return String.format("%.1f", Double.valueOf(j / 10000.0d)) + ExifInterface.LONGITUDE_WEST;
        }
        float f = ((float) (j / TimeUtils.NANOS_PER_MS)) / 10.0f;
        if (f >= 9999.0f) {
            return "9999KW+";
        }
        if (f % 1.0f == 0.0f) {
            return ((int) f) + "KW";
        }
        return f + "KW";
    }

    public static String cQ(long j) {
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
        } else if (j < 9.9999E10d) {
            float f2 = ((float) (j / TimeUtils.NANOS_PER_MS)) / 10.0f;
            if (f2 % 1.0f == 0.0f) {
                return ((int) f2) + "KW";
            }
            return f2 + "KW";
        } else {
            return "9999.9KW";
        }
    }

    public static String cR(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 10000000) {
            String format = String.format("%.1f", Double.valueOf(j / 10000.0d));
            if (format.endsWith(".0")) {
                format = format.substring(0, format.length() - 2);
            }
            return format + ExifInterface.LONGITUDE_WEST;
        }
        String format2 = String.format("%.1f", Double.valueOf((j / 1000000.0d) / 10.0d));
        if (format2.endsWith(".0")) {
            format2 = format2.substring(0, format2.length() - 2);
        }
        float f = com.baidu.adp.lib.f.b.toFloat(format2, 1.0f);
        if (f >= 9999.0f) {
            return "9999KW+";
        }
        if (f % 1.0f == 0.0f) {
            return ((int) f) + "KW";
        }
        return f + "KW";
    }

    public static String cS(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 10000000) {
            String format = String.format("%.1f", Double.valueOf(j / 10000.0d));
            if (format.endsWith(".0")) {
                format = format.substring(0, format.length() - 2);
            }
            return format + "w";
        }
        float f = ((float) (j / TimeUtils.NANOS_PER_MS)) / 10.0f;
        if (f >= 999.0f) {
            return "999kw+";
        }
        if (f % 1.0f == 0.0f) {
            return ((int) f) + "kw";
        }
        return f + "kw";
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

    public static String cT(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 100000) {
            return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
        }
        if (j < 10000000) {
            return (j / 10000) + ExifInterface.LONGITUDE_WEST;
        }
        float f = ((float) (j / TimeUtils.NANOS_PER_MS)) / 10.0f;
        if (f >= 9999.0f) {
            return "9999KW+";
        }
        if (f % 1.0f == 0.0f) {
            return ((int) f) + "KW";
        }
        return ((int) f) + "KW";
    }

    public static String cU(long j) {
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
        if (j < -99990000) {
            return "-9999W+";
        }
        if (j <= -10000000) {
            return String.valueOf(j / 10000) + ExifInterface.LONGITUDE_WEST;
        }
        if (j < -10000) {
            return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
        }
        if (j == -10000) {
            return "-1W";
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

    public static String formatTosepara(int i) {
        return new DecimalFormat("#,###").format(i);
    }

    public static String formatTosepara(long j) {
        return new DecimalFormat("#,###").format(j);
    }

    public static String formatOverBaiwanNum(long j) {
        float f;
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= 100000000) {
            if (j % 100000000 != 0) {
                return String.format("%.1f", Double.valueOf(((float) j) / 1.0E8f)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            }
            return (j / 100000000) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
        } else if (j >= TimeUtils.NANOS_PER_MS) {
            long j2 = j / 10000;
            if (((float) j) / 10000.0f > ((float) j2)) {
                return String.format("%.1f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return j2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
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

    public static String s(double d) {
        String format = String.format(Locale.getDefault(), "%.1f", Double.valueOf(d));
        if (format.endsWith(".0")) {
            format = format.substring(0, format.length() - 2);
        }
        if ("0".equals(format)) {
            format = "0.1";
        }
        return "<" + format + "km";
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
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(i)), lastIndexOf, str2.length() + lastIndexOf, 33);
        return spannableString;
    }

    public static SpannableString highLightText(String str, String str2, int i) {
        return highLightText(str, str2, i, true);
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
                    return str.substring(0, str.offsetByCodePoints(0, i - 1)) + StringHelper.STRING_MORE;
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
        return (str == null || i < 0 || str.length() == i) ? str : cutStringWithSuffix(str, i - 1, StringHelper.STRING_MORE);
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

    public static String aj(String str, int i) {
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
        if (i3 > i || i2 + 1 < length) {
            if (i3 + 2 < i) {
                return str.substring(0, i2 + 1) + StringHelper.STRING_MORE;
            }
            return str.substring(0, i2) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public static String getFormatSize(long j) {
        return ((float) j) >= SIZE_FLOAT_M ? String.format(Locale.getDefault(), "%.1fM", Float.valueOf(((float) j) / SIZE_FLOAT_M)) : ((float) j) >= SIZE_FLOAT_K / 10.0f ? String.format(Locale.getDefault(), "%.1fK", Float.valueOf(((float) j) / SIZE_FLOAT_K)) : TbadkCoreApplication.getInst().getString(R.string.less_than_zero_dot_one_k);
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
                    return String.format("%.2f", Double.valueOf(d)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                }
                return d2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            }
            return (j / 100000000) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
        } else if (j >= TimeUtils.NANOS_PER_MS) {
            float f = ((float) j) / 10000.0f;
            long j2 = j / 10000;
            if (j % TimeUtils.NANOS_PER_MS > 999) {
                return String.format("%.2f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return j2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
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
                return getFixedText(sb.toString(), i - 1, false) + StringHelper.STRING_MORE;
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
                return TbadkCoreApplication.getInst().getContext().getString(R.string.he);
            case 2:
                return TbadkCoreApplication.getInst().getContext().getString(R.string.she);
            default:
                return TbadkCoreApplication.getInst().getContext().getString(R.string.he);
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

    public static String R(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                sb.append(jSONArray.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i + 1 < length) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        return sb.toString();
    }

    public static boolean Ah(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return Ai(str) || sC(str);
    }

    public static boolean Ai(String str) {
        return str != null && str.length() > 6 && str.substring(0, 7).equalsIgnoreCase("http://");
    }

    public static boolean sC(String str) {
        return str != null && str.length() > 7 && str.substring(0, 8).equalsIgnoreCase(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }
}
