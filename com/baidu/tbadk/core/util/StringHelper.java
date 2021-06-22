package com.baidu.tbadk.core.util;

import android.net.ParseException;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.c.e.m.b;
import d.a.c.e.p.k;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class StringHelper extends k {
    public static long MS_TO_DAY = 0;
    public static long MS_TO_HOUR = 0;
    public static long MS_TO_MIN = 0;
    public static long MS_TO_SEC = 1000;
    public static float SIZE_FLOAT_K = 1024.0f;
    public static float SIZE_FLOAT_M = 1048576.0f;
    public static final String STRING_MORE = "...";
    public static String HOUR_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_hour_before);
    public static String MIN_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_min_before);
    public static String SEC_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_sec_before);
    public static String TIME_DAY = TbadkCoreApplication.getInst().getApp().getString(R.string.day);
    public static String TIME_HOUR = TbadkCoreApplication.getInst().getApp().getString(R.string.time_hour);
    public static String TIME_MINUTE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_minute);
    public static String TIME_SECOND = TbadkCoreApplication.getInst().getApp().getString(R.string.time_second);
    public static String ALA_CARD_DAY_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.ala_card_create_day);
    public static String ALA_CARD_HOUR_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.ala_card_create_hour);
    public static String ALA_CARD_MIN_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.ala_card_create_min);
    public static final SimpleDateFormat FORMATE_DATE_SECOND = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat FORMATE_DATE_SECOND_CHINESE = new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
    public static final SimpleDateFormat FORMATE_DATE_DAY_TIME = new SimpleDateFormat("dd日HH:mm");
    public static final SimpleDateFormat FORMATE_DATE_HOUR = new SimpleDateFormat("HH:mm");
    public static final SimpleDateFormat FORMATE_DATE_YEAR_M_D = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat FORMATE_MONTH_DAY_HOUR_MINUTE = new SimpleDateFormat("MM-dd HH:mm");
    public static final SimpleDateFormat FORMATE_MONTH_DAY = new SimpleDateFormat("MM-dd");
    public static final SimpleDateFormat FORMAT_MONTH_DAY_CHINEASE = new SimpleDateFormat("MM月dd日");
    public static final SimpleDateFormat FORMAT_DATE_YEAR_SECOND = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat FORMAT_DATE_MONTH_SECOND_ = new SimpleDateFormat("MM-dd HH:mm");
    public static Date date = new Date();

    static {
        long j = 1000 * 60;
        MS_TO_MIN = j;
        long j2 = j * 60;
        MS_TO_HOUR = j2;
        MS_TO_DAY = j2 * 24;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        if (timeZone != null) {
            k.FORMATE_DATE_ALL.setTimeZone(timeZone);
            k.FORMATE_DATE_YEAR.setTimeZone(timeZone);
            k.FORMATE_DATE_TIME.setTimeZone(timeZone);
            k.FORMATE_DATE_MOUTH.setTimeZone(timeZone);
            k.FORMATE_DATE_MOUTH_TIME.setTimeZone(timeZone);
            k.FORMATE_DATE_DAY.setTimeZone(timeZone);
            k.FORMATE_DATE_DAY_WEEK.setTimeZone(timeZone);
            k.FORMATE_DATE_DAY_1.setTimeZone(timeZone);
            k.FORMATE_DATE_MS.setTimeZone(timeZone);
            k.FORMATE_DATE_DAY_NO_YEAR.setTimeZone(timeZone);
        }
    }

    public static String GetPostTimeString(Date date2) {
        return date2 == null ? "" : getPostTimeString(new Date(), date2);
    }

    public static String JsonArrayToString(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = jSONArray.length();
        int i2 = 0;
        while (i2 < length) {
            try {
                sb.append(jSONArray.get(i2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            i2++;
            if (i2 < length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static int compareVersion(String str, String str2) {
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        long[] parseVersion = parseVersion(str);
        long[] parseVersion2 = parseVersion(str2);
        long j = 0;
        long j2 = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            j2 += parseVersion[i2] << (24 - (i2 * 8));
        }
        for (int i3 = 0; i3 < 3; i3++) {
            j += parseVersion2[i3] << (24 - (i3 * 8));
        }
        int i4 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
        if (i4 > 0) {
            return 1;
        }
        return i4 == 0 ? 0 : -1;
    }

    public static String cutChineseAndEnglishWithEmoji(String str, int i2, String str2) {
        if (str == null || i2 <= 0) {
            return "";
        }
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            i4 = k.isChinese(str.charAt(i3)) ? i4 + 2 : i4 + 1;
            if (i4 >= i2) {
                break;
            }
            i3++;
        }
        int i5 = i3 + 1;
        if (i5 < length) {
            if (str2 == null) {
                str2 = "";
            }
            String substring = str.substring(0, str.offsetByCodePoints(0, str.codePointCount(0, i5)));
            if (str.equals(substring)) {
                return substring;
            }
            return substring + str2;
        }
        return str;
    }

    public static String cutChineseAndEnglishWithSuffix(String str, int i2, String str2) {
        if (str == null || i2 <= 0) {
            return "";
        }
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            i4 = k.isChinese(str.charAt(i3)) ? i4 + 2 : i4 + 1;
            if (i4 >= i2) {
                break;
            }
            i3++;
        }
        int i5 = i3 + 1;
        if (i5 < length) {
            if (str2 == null) {
                str2 = "";
            }
            return str.substring(0, i5) + str2;
        }
        return str;
    }

    public static String cutForumNameWithSuffix(String str, int i2, String str2) {
        if (str == null || i2 <= 0) {
            return "";
        }
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            i4 = k.isChinese(str.charAt(i3)) ? i4 + 2 : i4 + 1;
            if (i4 >= i2) {
                break;
            }
            i3++;
        }
        int i5 = i3 + 1;
        if (i5 < length) {
            if (str2 == null) {
                str2 = "";
            }
            if (i4 + 2 < i2) {
                return str.substring(0, i5) + str2;
            }
            return str.substring(0, i3) + str2;
        }
        return str;
    }

    public static String cutHotTopicShow(String str, int i2, String str2) {
        if (str == null || i2 <= 0) {
            return "";
        }
        int length = str.length();
        if (str.indexOf("#") == 0 && str.lastIndexOf("#") == length - 1) {
            String replaceAll = str.replaceAll("#", "");
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                i4 = k.isChinese(replaceAll.charAt(i3)) ? i4 + 2 : i4 + 1;
                if (i4 >= i2) {
                    break;
                }
                i3++;
            }
            StringBuilder sb = new StringBuilder();
            int i5 = i3 + 1;
            if (i5 < length) {
                if (str2 == null) {
                    str2 = "";
                }
                sb.append("#");
                sb.append(replaceAll.substring(0, i5));
                sb.append(str2);
                sb.append("#");
                return sb.toString();
            }
            sb.append("#");
            sb.append(replaceAll);
            sb.append("#");
            return sb.toString();
        }
        return cutChineseAndEnglishWithSuffix(str, i2, str2);
    }

    @Deprecated
    public static String cutStringWithEllipsis(String str, int i2) {
        return (str == null || i2 < 0 || str.length() == i2) ? str : cutStringWithSuffix(str, i2 - 1, STRING_MORE);
    }

    public static String cutStringWithEllipsisNew(String str, int i2) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (i2 <= 0) {
            return str;
        }
        try {
            if (str.codePointCount(0, str.length()) <= i2) {
                return str;
            }
            String substring = str.substring(0, str.offsetByCodePoints(0, i2 - 1));
            return substring + STRING_MORE;
        } catch (Throwable th) {
            BdLog.e(th);
            return str;
        }
    }

    public static String cutStringWithEllipsisStrict(String str, int i2) {
        if (str == null || i2 <= 0) {
            return "";
        }
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            i4 = k.isChinese(str.charAt(i3)) ? i4 + 2 : i4 + 1;
            if (i4 >= i2) {
                break;
            }
            i3++;
        }
        if (i4 > i2 || i3 + 1 < length) {
            if (i4 + 2 < i2) {
                return str.substring(0, i3 + 1) + STRING_MORE;
            }
            return str.substring(0, i3) + STRING_MORE;
        }
        return str;
    }

    public static String cutStringWithSuffix(String str, int i2, String str2) {
        if (str == null || i2 < 0 || str.length() <= i2) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, i2));
        if (str2 == null) {
            sb.append("");
        } else {
            sb.append(str2);
        }
        return sb.toString();
    }

    public static String dateToConstellation(Date date2) {
        if (date2 == null) {
            return null;
        }
        String[] strArr = {"宝瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "室女座", "天秤座", "天蝎座", "人马座", "摩羯座"};
        int[] iArr = {20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22};
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date2);
            int i2 = calendar.get(5);
            int i3 = calendar.get(2);
            if (i2 < iArr[i3]) {
                i3--;
            }
            if (i3 < 0) {
                i3 = 11;
            }
            if (i3 >= 0 && i3 <= 11) {
                return strArr[i3];
            }
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static boolean equals(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static String forceLToR(String str) {
        if (k.isEmpty(str)) {
            return "";
        }
        return "\u202d" + str + "\u202c";
    }

    public static String formatDayOrHourTime(long j) {
        int i2 = (int) (j / 3600000);
        if (i2 >= 24) {
            return ((i2 / 24) + 1) + TIME_DAY;
        }
        return (i2 + 1) + TIME_HOUR;
    }

    public static String formatDayTime(long j) {
        return (((j / 3600000) / 24) + 1) + TIME_DAY;
    }

    public static String formatDistanceNum(double d2) {
        String format = String.format(Locale.getDefault(), "%.1f", Double.valueOf(d2));
        if (format.endsWith(".0")) {
            format = format.substring(0, format.length() - 2);
        }
        if ("0".equals(format)) {
            format = "0.1";
        }
        return "<" + format + "km";
    }

    public static String formatGiftNumForTDouDisPlay(long j) {
        String str;
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j < 100000000) {
            if (j >= 10000000) {
                float f2 = ((float) j) / 10000.0f;
                long j2 = j / 10000;
                if (j % 10000000 > 999) {
                    return String.format("%.2f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return j2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return valueOf;
        }
        long j3 = j % 100000000;
        if (j3 != 0) {
            double d2 = ((float) j) / 1.0E8f;
            double d3 = j / 100000000;
            if (j3 > 999999.0d) {
                str = String.format("%.2f", Double.valueOf(d2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            } else {
                str = d3 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            }
            return str;
        }
        return (j / 100000000) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
    }

    public static String formatNumForTdouDisPlay(long j) {
        String str;
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j < 100000000) {
            if (j >= 1000000) {
                float f2 = ((float) j) / 10000.0f;
                long j2 = j / 10000;
                if (j % 1000000 > 999) {
                    return String.format("%.2f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return j2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return valueOf;
        }
        long j3 = j % 100000000;
        if (j3 != 0) {
            double d2 = ((float) j) / 1.0E8f;
            double d3 = j / 100000000;
            if (j3 > 999999.0d) {
                str = String.format("%.2f", Double.valueOf(d2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            } else {
                str = d3 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            }
            return str;
        }
        return (j / 100000000) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
    }

    public static String formatOverBaiwanNum(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        String valueOf = String.valueOf(f2);
        if (f2 >= 1.0E8f) {
            if (f2 % 1.0E8f != 0.0f) {
                double d2 = f2 / 1.0E8f;
                return String.format("%.1f", Double.valueOf(d2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            }
            return (f2 / 1.0E8f) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
        } else if (f2 >= 1000000.0f) {
            float f3 = f2 / 10000.0f;
            long j = f3;
            if (f3 > ((float) j)) {
                return String.format("%.1f", Float.valueOf(f3)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return j + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
        } else {
            return valueOf;
        }
    }

    public static String formatSecondsTime(int i2) {
        int i3 = i2 / 1000;
        int i4 = i3 % 60;
        int i5 = (i3 / 60) % 60;
        int i6 = i3 / 3600;
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        sb.setLength(0);
        return i6 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4)).toString();
    }

    public static String formatTosepara(int i2) {
        return new DecimalFormat("#,###").format(i2);
    }

    public static String formatYdouOverBaiwanNum(float f2) {
        float f3;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 >= 1.0E8f) {
            if (f2 % 1.0E8f != 0.0f) {
                double d2 = f2 / 1.0E8f;
                return String.format("%.2f", Double.valueOf(d2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            }
            return (f2 / 1.0E8f) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
        } else if (f2 < 1000000.0f) {
            int i2 = (int) f2;
            if (f2 > i2) {
                return ((int) (100.0f * f2)) % 10 == 0 ? String.format("%.1f", Float.valueOf(f2)) : String.format("%.2f", Float.valueOf(f2));
            }
            return String.valueOf(i2);
        } else {
            long j = f2 / 10000;
            if (f2 / 10000.0f > ((float) j)) {
                return String.format("%.2f", Float.valueOf(f3)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return j + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
        }
    }

    public static String getBaAgeAutoYearAndMonth(String str) {
        if (TextUtils.isEmpty(str)) {
            return String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_less_one_year), 1);
        }
        float c2 = b.c(str, 0.0f);
        if (c2 > 1.0f) {
            return String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_more_one_year), Integer.valueOf(Math.round(c2)));
        }
        int round = Math.round(c2 * 12.0f);
        return round >= 12 ? String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_more_one_year), 1) : round < 1 ? String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_less_one_year), 1) : String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_less_one_year), Integer.valueOf(round));
    }

    public static String getChatTimeString(Date date2) {
        return getChatTimeString(new Date(), date2);
    }

    public static int getChineseAndEnglishLength(String str) {
        if (str == null) {
            return 0;
        }
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 = k.isChinese(str.charAt(i3)) ? i2 + 2 : i2 + 1;
        }
        return i2;
    }

    public static String getChineseFormatTimeString(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (FORMATE_DATE_SECOND_CHINESE) {
            format = FORMATE_DATE_SECOND_CHINESE.format(date2);
        }
        return format;
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

    public static String getChineseYearBytime(long j) {
        return getYearBytime(j) + "年";
    }

    public static String getCurrentString() {
        String format;
        Date date2 = new Date();
        synchronized (k.FORMATE_DATE_MS) {
            format = k.FORMATE_DATE_MS.format(date2);
        }
        return format;
    }

    public static String getCurrentTimeZoneDay() {
        String format;
        Date date2 = new Date();
        synchronized (k.FORMATE_DATE_DAY) {
            format = k.FORMATE_DATE_DAY.format(date2);
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

    public static String getDateBytime(long j) {
        int date2 = new Date(j).getDate();
        if (date2 < 10) {
            return "0" + String.valueOf(date2);
        }
        return String.valueOf(date2);
    }

    public static String getDateStringDHM(Date date2) {
        String format;
        synchronized (FORMATE_DATE_DAY_TIME) {
            format = FORMATE_DATE_DAY_TIME.format(date2);
        }
        return format;
    }

    public static String getDateStringDay1(Date date2) {
        String format;
        synchronized (k.FORMATE_DATE_DAY_1) {
            format = k.FORMATE_DATE_DAY_1.format(date2);
        }
        return format;
    }

    public static String getDateStringDayNoYear(Date date2) {
        String format;
        synchronized (k.FORMATE_DATE_DAY_NO_YEAR) {
            format = k.FORMATE_DATE_DAY_NO_YEAR.format(date2);
        }
        return format;
    }

    public static String getDateStringHM(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (FORMATE_DATE_HOUR) {
            format = FORMATE_DATE_HOUR.format(date2);
        }
        return format;
    }

    public static String getDateStringMHH(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (FORMAT_DATE_MONTH_SECOND_) {
            format = FORMAT_DATE_MONTH_SECOND_.format(date2);
        }
        return format;
    }

    public static String getDateStringMd(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (FORMATE_MONTH_DAY) {
            format = FORMATE_MONTH_DAY.format(date2);
        }
        return format;
    }

    public static String getDateStringMdChinease(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (FORMAT_MONTH_DAY_CHINEASE) {
            format = FORMAT_MONTH_DAY_CHINEASE.format(date2);
        }
        return format;
    }

    public static String getDateStringMdHm(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (FORMATE_MONTH_DAY_HOUR_MINUTE) {
            format = FORMATE_MONTH_DAY_HOUR_MINUTE.format(date2);
        }
        return format;
    }

    public static String getDateStringMdHmSs(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (FORMATE_DATE_SECOND) {
            format = FORMATE_DATE_SECOND.format(date2);
        }
        return format;
    }

    public static String getDateStringYMH(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (FORMAT_DATE_YEAR_SECOND) {
            format = FORMAT_DATE_YEAR_SECOND.format(date2);
        }
        return format;
    }

    public static String getDateStringYearMonthDay(Date date2) {
        String format;
        synchronized (FORMATE_DATE_YEAR_M_D) {
            format = FORMATE_DATE_YEAR_M_D.format(date2);
        }
        return format;
    }

    public static String getDateWeek(Date date2) {
        String format;
        synchronized (k.FORMATE_DATE_DAY_WEEK) {
            format = k.FORMATE_DATE_DAY_WEEK.format(date2);
        }
        return format;
    }

    public static String getFixedText(String str, int i2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        double d2 = 0.0d;
        int i3 = 0;
        while (true) {
            if (i3 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i3);
            d2 += ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9')) ? 1.0d : 0.5d;
            if (d2 <= i2) {
                sb.append(charAt);
                i3++;
            } else if (z) {
                String fixedText = getFixedText(sb.toString(), i2 - 1, false);
                return fixedText + STRING_MORE;
            }
        }
        return sb.toString();
    }

    public static String getFormatAlaLiveTime(long j) {
        String formatAlaLiveTime;
        synchronized (date) {
            date.setTime(j);
            formatAlaLiveTime = getFormatAlaLiveTime(date);
        }
        return formatAlaLiveTime;
    }

    public static String getFormatSize(long j) {
        float f2 = (float) j;
        return f2 >= SIZE_FLOAT_M ? String.format(Locale.getDefault(), "%.1fM", Float.valueOf(f2 / SIZE_FLOAT_M)) : f2 >= SIZE_FLOAT_K / 10.0f ? String.format(Locale.getDefault(), "%.1fK", Float.valueOf(f2 / SIZE_FLOAT_K)) : TbadkCoreApplication.getInst().getString(R.string.less_than_zero_dot_one_k);
    }

    public static String getFormatTime(long j) {
        String formatTime;
        synchronized (date) {
            date.setTime(j);
            formatTime = getFormatTime(date, false);
        }
        return formatTime;
    }

    public static String getFormatTimeForAlaCardCreate(long j) {
        String formatTimeForAlaCardCreate;
        synchronized (date) {
            date.setTime(j);
            formatTimeForAlaCardCreate = getFormatTimeForAlaCardCreate(date);
        }
        return formatTimeForAlaCardCreate;
    }

    public static String getFormatTimeForHomeC(long j) {
        String formatTimeHomeC;
        synchronized (date) {
            date.setTime(j);
            formatTimeHomeC = getFormatTimeHomeC(date);
        }
        return formatTimeHomeC;
    }

    public static String getFormatTimeForJustNow(long j) {
        String formatTimeForJustNow;
        synchronized (date) {
            date.setTime(j);
            formatTimeForJustNow = getFormatTimeForJustNow(date, false);
        }
        return formatTimeForJustNow;
    }

    public static String getFormatTimeHomeC(Date date2) {
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

    public static String getFormatTimeShort(long j) {
        String formatTime;
        synchronized (date) {
            date.setTime(j);
            formatTime = getFormatTime(date, true);
        }
        return formatTime;
    }

    public static String getHighLightString(String str, String str2) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (StringUtils.isNull(str2)) {
            str2 = "#007bd1";
        }
        String str3 = null;
        try {
            str3 = str.replaceAll("<em>", "<font color='" + str2 + "'>");
            return str3.replaceAll("</em>", "</font>");
        } catch (Exception e2) {
            BdLog.e(e2.toString());
            return str3;
        }
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
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public static String getNegativeInfinity() {
        return "-∞";
    }

    public static String getPostTimeInterval(long j) {
        long abs = Math.abs(System.currentTimeMillis() - (j * 1000));
        if (abs <= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            return "刚刚";
        }
        if (abs < Long.MAX_VALUE && abs / MS_TO_DAY == 0) {
            if (abs / MS_TO_HOUR != 0) {
                return (abs / MS_TO_HOUR) + "小时前";
            }
            return (abs / MS_TO_MIN) + "分钟前";
        }
        return "";
    }

    public static String getPostTimeString(Date date2, Date date3) {
        if (date3 == null) {
            return "";
        }
        int day = date2.getDay() - date3.getDay();
        long time = date2.getTime() - date3.getTime();
        if (time < 0) {
            return time > -120000 ? "刚刚" : k.getDateStringDay(date3);
        } else if (time < 30000) {
            return "刚刚";
        } else {
            if (time < 60000) {
                return "半分钟前";
            }
            if (time < 3600000) {
                return String.valueOf((time * 60) / 3600000) + "分钟前";
            } else if (time < 86400000) {
                return day == 0 ? k.getDateStringHm(date3) : "1天前";
            } else if (time >= 2678400000L) {
                return time < 2764800000L ? "1个月前" : k.getDateStringDay(date3);
            } else {
                return String.valueOf((time * 31) / 2678400000L) + "天前";
            }
        }
    }

    public static int getRealSize(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 = k.isChinese(str.charAt(i3)) ? i2 + 2 : i2 + 1;
        }
        return i2;
    }

    public static int getRealSize2(String str) {
        byte[] bytes;
        int i2 = 0;
        if (str == null || (bytes = str.getBytes()) == null) {
            return 0;
        }
        int length = bytes.length;
        int i3 = 0;
        while (i2 < length) {
            int i4 = bytes[i2] & 255;
            if (i4 >= 252) {
                i3 += 2;
                i2 += 6;
            } else if (i4 >= 248) {
                i3 += 2;
                i2 += 5;
            } else if (i4 >= 240) {
                i3 += 2;
                i2 += 4;
            } else if (i4 >= 224) {
                i3 += 2;
                i2 += 3;
            } else if (i4 >= 192) {
                i3 += 2;
                i2 += 2;
            } else {
                i3++;
                i2++;
            }
        }
        return i3;
    }

    public static String getStringYearToSecond(Date date2) {
        String format;
        synchronized (FORMATE_DATE_SECOND) {
            format = FORMATE_DATE_SECOND.format(date2);
        }
        return format;
    }

    public static String getTimeInterval(long j) {
        long abs = Math.abs(System.currentTimeMillis() - (j * 1000));
        if (abs <= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            return "刚刚";
        }
        if (abs >= Long.MAX_VALUE) {
            return "一个月前";
        }
        long j2 = MS_TO_DAY;
        if (abs / j2 != 0) {
            if (abs / j2 > 30) {
                return "一个月前";
            }
            return (abs / MS_TO_DAY) + "天前";
        } else if (abs / MS_TO_HOUR != 0) {
            return (abs / MS_TO_HOUR) + "小时前";
        } else {
            return (abs / MS_TO_MIN) + "分钟前";
        }
    }

    public static String getTimeSpace(long j) {
        if (j <= 0) {
            return "1秒";
        }
        long j2 = MS_TO_DAY;
        if (j < j2) {
            if (j < MS_TO_HOUR) {
                if (j < MS_TO_MIN) {
                    long j3 = j / MS_TO_SEC;
                    if (j3 == 0) {
                        j3 = 1;
                    }
                    return String.valueOf(j3) + TIME_SECOND;
                }
                return String.valueOf(j / MS_TO_MIN) + TIME_MINUTE;
            }
            return String.valueOf(j / MS_TO_HOUR) + TIME_HOUR;
        }
        return String.valueOf(j / j2) + TIME_DAY;
    }

    public static String getUserDescByGender(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return TbadkCoreApplication.getInst().getContext().getString(R.string.he);
            }
            return TbadkCoreApplication.getInst().getContext().getString(R.string.she);
        }
        return TbadkCoreApplication.getInst().getContext().getString(R.string.he);
    }

    public static String getWeekString(int i2, int i3, int i4) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i2);
        calendar.set(2, i3);
        calendar.set(5, i4);
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

    public static String getYearBytime(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return String.valueOf(calendar.get(1));
    }

    public static int getyyyyMMddTimeForNow() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(1) * 10000) + 0 + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    public static SpannableString highLightText(String str, String str2, int i2, boolean z) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && i2 > 0) {
            SpannableString spannableString = new SpannableString(str);
            if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                if (z) {
                    lastIndexOf = str.indexOf(str2);
                } else {
                    lastIndexOf = str.lastIndexOf(str2);
                }
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i2)), lastIndexOf, str2.length() + lastIndexOf, 33);
            }
            return spannableString;
        }
        return new SpannableString("");
    }

    public static boolean isHttpUrl(String str) {
        return str != null && str.length() > 6 && str.substring(0, 7).equalsIgnoreCase("http://");
    }

    public static boolean isHttpsUrl(String str) {
        return str != null && str.length() > 7 && str.substring(0, 8).equalsIgnoreCase("https://");
    }

    public static boolean isJSONArray(String str) {
        if (!k.isEmpty(str)) {
            String trim = str.trim();
            if (trim.startsWith(PreferencesUtil.LEFT_MOUNT) && trim.endsWith(PreferencesUtil.RIGHT_MOUNT)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isJSONObject(String str) {
        if (!k.isEmpty(str)) {
            String trim = str.trim();
            if (trim.startsWith(StringUtil.ARRAY_START) && trim.endsWith("}")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNetworkUrl(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return isHttpUrl(str) || isHttpsUrl(str);
    }

    public static boolean isTaday(long j) {
        Time time = new Time();
        time.set(j);
        int i2 = time.year;
        int i3 = time.month;
        int i4 = time.monthDay;
        time.set(System.currentTimeMillis());
        return i2 == time.year && i3 == time.month && i4 == time.monthDay;
    }

    public static boolean isThisYear(String str) {
        if (str.length() != 10) {
            return false;
        }
        return FORMATE_DATE_YEAR_M_D.format(new Date()).substring(0, 4).equals(str.substring(0, 4));
    }

    public static String long2String(long j, String str) {
        Date date2;
        if (String.valueOf(j).length() == 10) {
            date2 = new Date(j * 1000);
        } else {
            date2 = new Date(j);
        }
        return new SimpleDateFormat(str).format(date2);
    }

    public static String longNumFormatOver(long j) {
        if (j <= 9999999) {
            if (j < 0) {
                return "0";
            }
            return "" + j;
        }
        float f2 = ((float) j) / 10000.0f;
        long round = Math.round(f2);
        if (((float) round) > f2) {
            round--;
        }
        return round + "w+";
    }

    public static String longNumFormatOver10000(long j) {
        if (j <= 9999) {
            if (j < 0) {
                return "0";
            }
            return "" + j;
        }
        float f2 = ((float) j) / 10000.0f;
        long round = Math.round(f2);
        if (((float) round) > f2) {
            round--;
        }
        return round + "W";
    }

    public static String longNumFormatOver10000wan(long j) {
        if (j <= 9999999) {
            if (j < 0) {
                return "0";
            }
            return "" + j;
        }
        float f2 = ((float) j) / 10000.0f;
        long round = Math.round(f2);
        if (((float) round) > f2) {
            round--;
        }
        return round + "w+";
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

    public static String longNumFormatOver9999wan(long j) {
        if (j < 0) {
            return "0";
        }
        if (j > 99990000) {
            return "9999W+";
        }
        if (j > 9999) {
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            float f2 = ((float) j) / 10000.0f;
            if (f2 < 1000.0f) {
                return decimalFormat.format(f2) + "W";
            }
            long round = Math.round(f2);
            if (((float) round) > f2) {
                round--;
            }
            return round + "W";
        }
        return String.valueOf(j);
    }

    public static String longNumFormatOver9999wanDoublePoint(double d2) {
        if (d2 < 0.0d) {
            return "0";
        }
        if (d2 > 9.999E7d) {
            return "9999万+";
        }
        if (d2 > 9999.0d) {
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            return decimalFormat.format(((float) d2) / 10000.0f) + "万";
        }
        return new DecimalFormat("#0.00").format(d2);
    }

    public static String longNumFormatOver9999wanOnePoint(long j) {
        if (j < 0) {
            return "0";
        }
        if (j > 99990000) {
            return "9999万+";
        }
        if (j > 9999) {
            DecimalFormat decimalFormat = new DecimalFormat("#0.0");
            return decimalFormat.format(((float) j) / 10000.0f) + "万";
        }
        return "" + j;
    }

    @Deprecated
    public static String numFormat(int i2) {
        if (i2 > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(i2 / 10000.0f));
        }
        if (i2 < 0) {
            return "0";
        }
        return "" + i2;
    }

    public static String numFormat9999W(long j) {
        if (j <= 9999999) {
            if (j < 0) {
                return "0";
            }
            return "" + j;
        }
        float f2 = ((float) j) / 10000.0f;
        long round = Math.round(f2);
        if (((float) round) > f2) {
            round--;
        }
        if (round >= 9999) {
            return "9999W+";
        }
        return j + "W";
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

    public static String numFormatOver100000ReturnInt(long j) {
        if (j > 99999) {
            return ((int) (((float) j) / 10000.0f)) + "W";
        } else if (j < 0) {
            return "0";
        } else {
            return "" + j;
        }
    }

    public static String numFormatOver10000ReturnInt(long j) {
        if (j > 9999) {
            return ((int) (((float) j) / 10000.0f)) + "W";
        } else if (j < 0) {
            return "0";
        } else {
            return "" + j;
        }
    }

    public static String numFormatOver10000wan(float f2) {
        if (f2 <= 9999999.0f) {
            if (f2 < 0.0f) {
                return "0";
            }
            return "" + f2;
        }
        float f3 = f2 / 10000.0f;
        long round = Math.round(f3);
        if (((float) round) > f3) {
            round--;
        }
        return round + "W";
    }

    public static String numFormatOverWan(long j) {
        if (j > 99990000) {
            return "9999W+";
        }
        if (j >= 10000000) {
            return String.valueOf(j / 10000) + "W";
        }
        int i2 = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
        if (i2 > 0) {
            return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
        }
        if (i2 == 0) {
            return "1W";
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
            return String.valueOf(j / 10000) + "W";
        }
        int i2 = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
        if (i2 > 0) {
            return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
        }
        if (i2 == 0) {
            return "1W";
        }
        if (j < 0) {
            return "--";
        }
        return "" + j;
    }

    public static String numFormatOverWanWithNegative(long j) {
        if (j > 99990000) {
            return "9999W+";
        }
        if (j >= 10000000) {
            return String.valueOf(j / 10000) + "W";
        }
        int i2 = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
        if (i2 > 0) {
            return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
        }
        if (i2 == 0) {
            return "1W";
        }
        if (j < -99990000) {
            return "-9999W+";
        }
        if (j <= -10000000) {
            return String.valueOf(j / 10000) + "W";
        }
        int i3 = (j > (-10000L) ? 1 : (j == (-10000L) ? 0 : -1));
        if (i3 < 0) {
            return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
        }
        if (i3 == 0) {
            return "-1W";
        }
        return "" + j;
    }

    public static String numFormatOverWanWithoutDecimals(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        } else if (j < 100000) {
            return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
        } else {
            if (j < 10000000) {
                return (j / 10000) + "W";
            }
            float f2 = ((float) (j / 1000000)) / 10.0f;
            if (f2 >= 9999.0f) {
                return "9999KW+";
            }
            if (f2 % 1.0f == 0.0f) {
                return ((int) f2) + "KW";
            }
            return ((int) f2) + "KW";
        }
    }

    public static String numOver1000(int i2) {
        if (i2 > 1000) {
            return "999+";
        }
        if (i2 < 0) {
            return "0";
        }
        return "" + i2;
    }

    public static String numberUniform(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        } else if (j < 9999000.0d) {
            float f2 = ((float) (j / 1000)) / 10.0f;
            if (f2 % 1.0f == 0.0f) {
                return ((int) f2) + "万";
            }
            return f2 + "万";
        } else {
            return "999.9万";
        }
    }

    public static String numberUniformFormat(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        } else if (j < 10000000) {
            float f2 = ((float) (j / 1000)) / 10.0f;
            if (f2 % 1.0f == 0.0f) {
                return ((int) f2) + "万";
            }
            return f2 + "万";
        } else {
            float f3 = ((float) (j / 1000000)) / 10.0f;
            if (f3 % 1.0f == 0.0f) {
                return ((int) f3) + "千万";
            }
            return f3 + "千万";
        }
    }

    public static String numberUniformFormatExtra(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        } else if (j < 10000000) {
            float f2 = ((float) (j / 1000)) / 10.0f;
            if (f2 % 1.0f == 0.0f) {
                return ((int) f2) + "W";
            }
            return f2 + "W";
        } else {
            float f3 = ((float) (j / 1000000)) / 10.0f;
            if (f3 >= 9999.0f) {
                return "9999KW+";
            }
            if (f3 % 1.0f == 0.0f) {
                return ((int) f3) + "KW";
            }
            return f3 + "KW";
        }
    }

    public static String numberUniformFormatExtraWithRound(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        } else if (j < 10000000) {
            return String.format("%.1f", Double.valueOf(j / 10000.0d)) + "W";
        } else {
            float f2 = ((float) (j / 1000000)) / 10.0f;
            if (f2 >= 9999.0f) {
                return "9999KW+";
            }
            if (f2 % 1.0f == 0.0f) {
                return ((int) f2) + "KW";
            }
            return f2 + "KW";
        }
    }

    public static String numberUniformFormatExtraWithRoundFloat(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        double d2 = j;
        if (d2 < 9999000.0d) {
            float f2 = ((float) (j / 1000)) / 10.0f;
            if (f2 % 1.0f == 0.0f) {
                return ((int) f2) + "W";
            }
            return f2 + "W";
        } else if (d2 < 9.9999E10d) {
            float f3 = ((float) (j / 1000000)) / 10.0f;
            if (f3 % 1.0f == 0.0f) {
                return ((int) f3) + "KW";
            }
            return f3 + "KW";
        } else {
            return "9999.9KW";
        }
    }

    public static String numberUniformFormatExtraWithRoundInt(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        } else if (j < 10000000) {
            String format = String.format("%.1f", Double.valueOf(j / 10000.0d));
            if (format.endsWith(".0")) {
                format = format.substring(0, format.length() - 2);
            }
            return format + "W";
        } else {
            String format2 = String.format("%.1f", Double.valueOf((j / 1000000.0d) / 10.0d));
            if (format2.endsWith(".0")) {
                format2 = format2.substring(0, format2.length() - 2);
            }
            float c2 = b.c(format2, 1.0f);
            if (c2 >= 9999.0f) {
                return "9999KW+";
            }
            if (c2 % 1.0f == 0.0f) {
                return ((int) c2) + "KW";
            }
            return c2 + "KW";
        }
    }

    public static String numberUniformFormatExtraWithRoundVote(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        } else if (j < 10000000) {
            String format = String.format("%.1f", Double.valueOf(j / 10000.0d));
            if (format.endsWith(".0")) {
                format = format.substring(0, format.length() - 2);
            }
            return format + "w";
        } else {
            float f2 = ((float) (j / 1000000)) / 10.0f;
            if (f2 >= 999.0f) {
                return "999kw+";
            }
            if (f2 % 1.0f == 0.0f) {
                return ((int) f2) + TiebaStatic.Params.H5_FORUM_NAME;
            }
            return f2 + TiebaStatic.Params.H5_FORUM_NAME;
        }
    }

    public static String numberUniformOver1000Wan(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        } else if (j < 9999000.0d) {
            float f2 = ((float) (j / 1000)) / 10.0f;
            if (f2 % 1.0f == 0.0f) {
                return ((int) f2) + "W";
            }
            return f2 + "W";
        } else {
            return "999.9W";
        }
    }

    public static long[] parseVersion(String str) {
        long[] jArr = new long[3];
        if (str != null) {
            String[] split = str.replace(".", "#").split("#");
            jArr[0] = Long.parseLong(split[0]);
            jArr[1] = Long.parseLong(split[1]);
            jArr[2] = Long.parseLong(split[2]);
        }
        return jArr;
    }

    public static String showTimeString(long j) {
        String valueOf;
        Date date2 = new Date(j);
        if (date2.getMinutes() < 10) {
            valueOf = "0" + date2.getMinutes();
        } else {
            valueOf = String.valueOf(date2.getMinutes());
        }
        return date2.getHours() > 12 ? TbadkCoreApplication.getInst().getApp().getString(R.string.time_show_afternoon, new Object[]{String.valueOf(date2.getHours() - 12), valueOf}) : date2.getHours() == 12 ? TbadkCoreApplication.getInst().getApp().getString(R.string.time_show_afternoon, new Object[]{String.valueOf(date2.getHours()), valueOf}) : date2.getHours() == 0 ? TbadkCoreApplication.getInst().getApp().getString(R.string.time_show_morning, new Object[]{String.valueOf(12), valueOf}) : TbadkCoreApplication.getInst().getApp().getString(R.string.time_show_morning, new Object[]{String.valueOf(date2.getHours()), valueOf});
    }

    public static long string2long(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (java.text.ParseException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String stringForVideoTime(int i2) {
        if (i2 < 1000) {
            i2 = 1000;
        }
        int i3 = i2 / 1000;
        int i4 = i3 % 60;
        int i5 = (i3 / 60) % 60;
        int i6 = i3 / 3600;
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        sb.setLength(0);
        return i6 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4)).toString();
    }

    public static String subString(String str, int i2) {
        if (str == null || i2 <= 0) {
            return "";
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            i3 = k.isChinese(charAt) ? i3 + 2 : i3 + 1;
            if (i3 > i2) {
                break;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static String subString2(String str, int i2) {
        byte[] bytes;
        int i3;
        if (str == null || i2 < 0 || (bytes = str.getBytes()) == null) {
            return null;
        }
        int length = bytes.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = bytes[i4] & 255;
            if (i6 >= 252) {
                i5 += 2;
                i3 = 6;
            } else if (i6 >= 248) {
                i5 += 2;
                i3 = 5;
            } else if (i6 >= 240) {
                i5 += 2;
                i3 = 4;
            } else if (i6 >= 224) {
                i5 += 2;
                i3 = 3;
            } else if (i6 >= 192) {
                i5 += 2;
                i3 = 2;
            } else {
                i5++;
                i3 = 1;
            }
            if (i5 > i2) {
                byte[] bArr = new byte[i4];
                System.arraycopy(bytes, 0, bArr, 0, i4);
                return new String(bArr);
            } else if (i5 == i2) {
                int i7 = i4 + i3;
                byte[] bArr2 = new byte[i7];
                System.arraycopy(bytes, 0, bArr2, 0, i7);
                return new String(bArr2);
            } else {
                i4 += i3;
            }
        }
        return str;
    }

    public static String trim(String str) {
        return str != null ? str.trim() : "";
    }

    public static SpannableStringBuilder forceLToR(SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder == null) {
            return new SpannableStringBuilder("");
        }
        return new SpannableStringBuilder("\u202d").append((CharSequence) spannableStringBuilder).append((CharSequence) "\u202c");
    }

    public static String formatTosepara(long j) {
        return new DecimalFormat("#,###").format(j);
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
            return time > -120000 ? "刚刚" : k.getDateStringDay(date3);
        } else if (time < 30000) {
            return "刚刚";
        } else {
            if (time < 60000) {
                return "半分钟前";
            }
            if (time < 3600000) {
                return String.valueOf((time * 60) / 3600000) + "分钟前";
            } else if (time < 86400000) {
                return day == 0 ? k.getDateStringHm(date3) : "1天前";
            } else if (time < 2678400000L) {
                return String.valueOf((time * 31) / 2678400000L) + "天前";
            } else if (time < 2764800000L) {
                return "1个月前";
            } else {
                if (date2.getYear() == date3.getYear()) {
                    synchronized (k.FORMATE_DATE_DAY_NO_YEAR) {
                        format2 = k.FORMATE_DATE_DAY_NO_YEAR.format(date3);
                    }
                    return format2;
                }
                synchronized (k.FORMATE_DATE_DAY) {
                    format = k.FORMATE_DATE_DAY.format(date3);
                }
                return format;
            }
        }
    }

    public static String numFormatOver10000wan(long j) {
        if (j <= 9999999) {
            if (j < 0) {
                return "0";
            }
            return "" + j;
        }
        float f2 = ((float) j) / 10000.0f;
        long round = Math.round(f2);
        if (((float) round) > f2) {
            round--;
        }
        return round + "W";
    }

    public static String getFormatAlaLiveTime(Date date2) {
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

    public static String getFormatTime(Date date2, boolean z) {
        if (date2 == null) {
            return "";
        }
        long time = new Date().getTime() - date2.getTime();
        if (time >= MS_TO_DAY || time <= 0) {
            if (z) {
                return getDateStringDayNoYear(date2);
            }
            return k.getDateStringDay(date2);
        } else if (time < MS_TO_HOUR) {
            if (time < MS_TO_MIN) {
                long j = time / MS_TO_SEC;
                if (j == 0) {
                    j = 1;
                }
                return String.valueOf(j) + SEC_BEFORE;
            }
            return String.valueOf(time / MS_TO_MIN) + MIN_BEFORE;
        } else {
            return String.valueOf(time / MS_TO_HOUR) + HOUR_BEFORE;
        }
    }

    public static String getFormatTimeForAlaCardCreate(Date date2) {
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
                    return "1" + ALA_CARD_MIN_BEFORE;
                }
                return String.valueOf(time / MS_TO_MIN) + ALA_CARD_MIN_BEFORE;
            }
            return String.valueOf(time / MS_TO_HOUR) + ALA_CARD_HOUR_BEFORE;
        }
        return String.valueOf(time / MS_TO_DAY) + ALA_CARD_DAY_BEFORE;
    }

    public static String getFormatTimeForJustNow(Date date2, boolean z) {
        if (date2 == null) {
            return "";
        }
        long time = new Date().getTime() - date2.getTime();
        if (time >= MS_TO_DAY || time <= 0) {
            if (z) {
                return getDateStringDayNoYear(date2);
            }
            return k.getDateStringDay(date2);
        } else if (time < MS_TO_HOUR) {
            if (time < MS_TO_MIN) {
                return "刚刚";
            }
            return String.valueOf(time / MS_TO_MIN) + MIN_BEFORE;
        } else {
            return String.valueOf(time / MS_TO_HOUR) + HOUR_BEFORE;
        }
    }

    public static String formatOverBaiwanNum(long j) {
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= 100000000) {
            if (j % 100000000 != 0) {
                return String.format("%.1f", Double.valueOf(((float) j) / 1.0E8f)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            }
            return (j / 100000000) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
        } else if (j >= 1000000) {
            float f2 = ((float) j) / 10000.0f;
            long j2 = j / 10000;
            if (f2 > ((float) j2)) {
                return String.format("%.1f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return j2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
        } else {
            return valueOf;
        }
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

    public static SpannableString highLightText(String str, int i2, int i3, int i4) {
        if (!TextUtils.isEmpty(str) && i4 > 0) {
            SpannableString spannableString = new SpannableString(str);
            if (i2 < i3 && i2 < str.length() && str.length() >= i3) {
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i4)), i2, i3, 33);
            }
            return spannableString;
        }
        return new SpannableString("");
    }

    public static SpannableString highLightText(String str, String str2, int i2) {
        return highLightText(str, str2, i2, true);
    }
}
