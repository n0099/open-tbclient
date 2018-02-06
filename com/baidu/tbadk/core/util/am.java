package com.baidu.tbadk.core.util;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.lib.util.k {
    private static long aXk = 1000;
    private static long aXl = aXk * 60;
    public static long aXm = aXl * 60;
    private static long aXn = aXm * 24;
    private static float aXo = 1048576.0f;
    private static float aXp = 1024.0f;
    private static String aXq = TbadkCoreApplication.getInst().getApp().getString(d.j.time_hour_before);
    private static String aXr = TbadkCoreApplication.getInst().getApp().getString(d.j.time_min_before);
    private static String aXs = TbadkCoreApplication.getInst().getApp().getString(d.j.time_sec_before);
    private static String aXt = TbadkCoreApplication.getInst().getApp().getString(d.j.day);
    private static String aXu = TbadkCoreApplication.getInst().getApp().getString(d.j.time_hour);
    private static String aXv = TbadkCoreApplication.getInst().getApp().getString(d.j.time_minute);
    private static String aXw = TbadkCoreApplication.getInst().getApp().getString(d.j.time_second);
    private static final SimpleDateFormat aXx = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat aXy = new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
    private static Date date = new Date();

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        if (timeZone != null) {
            amz.setTimeZone(timeZone);
            amA.setTimeZone(timeZone);
            amB.setTimeZone(timeZone);
            amC.setTimeZone(timeZone);
            amD.setTimeZone(timeZone);
            amE.setTimeZone(timeZone);
            amF.setTimeZone(timeZone);
            amG.setTimeZone(timeZone);
            amH.setTimeZone(timeZone);
            amI.setTimeZone(timeZone);
        }
    }

    public static String fR(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        sb.setLength(0);
        return i5 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public static String Db() {
        String format;
        Date date2 = new Date();
        synchronized (amH) {
            format = amH.format(date2);
        }
        return format;
    }

    public static String v(int i, int i2, int i3) {
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

    public static int Dc() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(5) + 0 + (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100);
    }

    public static String e(Date date2) {
        return date2 == null ? "" : b(new Date(), date2);
    }

    public static String b(Date date2, Date date3) {
        if (date3 == null) {
            return "";
        }
        int day = date2.getDay() - date3.getDay();
        long time = date2.getTime() - date3.getTime();
        if (time < 0) {
            if (time > -120000) {
                return "刚刚";
            }
            return d(date3);
        } else if (time >= StatisticConfig.MIN_UPLOAD_INTERVAL) {
            long j = StatisticConfig.MIN_UPLOAD_INTERVAL * 2;
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
                    return b(date3);
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
            return d(date3);
        } else {
            return "刚刚";
        }
    }

    public static String f(Date date2) {
        return c(new Date(), date2);
    }

    public static String c(Date date2, Date date3) {
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
            return d(date3);
        } else if (time >= StatisticConfig.MIN_UPLOAD_INTERVAL) {
            long j = StatisticConfig.MIN_UPLOAD_INTERVAL * 2;
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
                    return b(date3);
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
                synchronized (amI) {
                    format2 = amI.format(date3);
                }
                return format2;
            }
            synchronized (amE) {
                format = amE.format(date3);
            }
            return format;
        } else {
            return "刚刚";
        }
    }

    public static String x(long j) {
        long abs = Math.abs(System.currentTimeMillis() - (1000 * j));
        if (abs <= 120000) {
            return "刚刚";
        }
        if (abs >= Long.MAX_VALUE) {
            return "一个月前";
        }
        if (abs / aXn != 0) {
            if (abs / aXn > 30) {
                return "一个月前";
            }
            return (abs / aXn) + "天前";
        } else if (abs / aXm != 0) {
            return (abs / aXm) + "小时前";
        } else {
            return (abs / aXl) + "分钟前";
        }
    }

    public static String y(long j) {
        long abs = Math.abs(System.currentTimeMillis() - (1000 * j));
        if (abs <= 120000) {
            return "刚刚";
        }
        if (abs >= Long.MAX_VALUE || abs / aXn != 0) {
            return "";
        }
        if (abs / aXm != 0) {
            return (abs / aXm) + "小时前";
        }
        return (abs / aXl) + "分钟前";
    }

    public static String ac(String str, String str2) {
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

    public static String z(long j) {
        String a;
        synchronized (date) {
            date.setTime(j);
            a = a(date, false);
        }
        return a;
    }

    public static String A(long j) {
        String a;
        synchronized (date) {
            date.setTime(j);
            a = a(date, true);
        }
        return a;
    }

    private static String a(Date date2, boolean z) {
        if (date2 == null) {
            return "";
        }
        long time = new Date().getTime() - date2.getTime();
        if (time < aXn && time > 0) {
            if (time < aXm) {
                if (time < aXl) {
                    long j = time / aXk;
                    if (j == 0) {
                        j = 1;
                    }
                    return String.valueOf(j) + aXs;
                }
                return String.valueOf(time / aXl) + aXr;
            }
            return String.valueOf(time / aXm) + aXq;
        } else if (z) {
            return g(date2);
        } else {
            return d(date2);
        }
    }

    public static String g(Date date2) {
        String format;
        synchronized (amI) {
            format = amI.format(date2);
        }
        return format;
    }

    public static String B(long j) {
        if (j <= 0) {
            return "1秒";
        }
        if (j < aXn) {
            if (j < aXm) {
                if (j < aXl) {
                    long j2 = j / aXk;
                    if (j2 == 0) {
                        j2 = 1;
                    }
                    return String.valueOf(j2) + aXw;
                }
                return String.valueOf(j / aXl) + aXv;
            }
            return String.valueOf(j / aXm) + aXu;
        }
        return String.valueOf(j / aXn) + aXt;
    }

    @Deprecated
    public static String fS(int i) {
        if (i > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(i / 10000.0f));
        }
        if (i < 0) {
            return "0";
        }
        return "" + i;
    }

    public static String C(long j) {
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
        float f2 = ((float) (j / 1000000)) / 10.0f;
        if (f2 % 1.0f == 0.0f) {
            return ((int) f2) + "千万";
        }
        return f2 + "千万";
    }

    public static String g(double d) {
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

    public static String D(long j) {
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

    public static String E(long j) {
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

    public static String F(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return j + "";
        }
        if (j < 10000000) {
            float f = ((float) (j / 1000)) / 10.0f;
            if (f % 1.0f == 0.0f) {
                return ((int) f) + "W";
            }
            return f + "W";
        }
        float f2 = ((float) (j / 1000000)) / 10.0f;
        if (f2 >= 9999.0f) {
            return "9999KW+";
        }
        if (f2 % 1.0f == 0.0f) {
            return ((int) f2) + "KW";
        }
        return f2 + "KW";
    }

    public static String G(long j) {
        if (j > 9990000) {
            return "999W+";
        }
        if (j < 0) {
            return "0";
        }
        return "" + j;
    }

    public static String H(long j) {
        if (j > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(((float) j) / 10000.0f));
        }
        if (j < 0) {
            return "0";
        }
        return "" + j;
    }

    public static String I(long j) {
        if (j > 99990000) {
            return "9999W+";
        }
        if (j >= 10000000) {
            return String.valueOf(j / 10000) + "W";
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

    public static String J(long j) {
        if (j > 99990000) {
            return "9999W+";
        }
        if (j >= 10000000) {
            return String.valueOf(j / 10000) + "W";
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

    public static String K(long j) {
        if (j > 9999999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return round + "W";
        } else if (j < 0) {
            return "0";
        } else {
            return "" + j;
        }
    }

    public static String L(long j) {
        if (j > 9999999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return round >= 9999 ? "9999W+" : j + "W";
        } else if (j < 0) {
            return "0";
        } else {
            return "" + j;
        }
    }

    public static String fT(int i) {
        return new DecimalFormat("#,###").format(i);
    }

    public static String formatTosepara(long j) {
        return new DecimalFormat("#,###").format(j);
    }

    public static String M(long j) {
        float f;
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= 100000000) {
            if (j % 100000000 != 0) {
                return String.format("%.1f", Double.valueOf(((float) j) / 1.0E8f)) + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_yi);
            }
            return (j / 100000000) + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_yi);
        } else if (j >= 1000000) {
            long j2 = j / 10000;
            if (((float) j) / 10000.0f > ((float) j2)) {
                return String.format("%.1f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_wan);
            }
            return j2 + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_wan);
        } else {
            return valueOf;
        }
    }

    public static String N(long j) {
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
                return decimalFormat.format(f) + "W";
            }
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return round + "W";
        }
        return String.valueOf(j);
    }

    public static String a(long j, String str) {
        Date date2;
        if (String.valueOf(j).length() == 10) {
            date2 = new Date(1000 * j);
        } else {
            date2 = new Date(j);
        }
        return new SimpleDateFormat(str).format(date2);
    }

    public static String eq(String str) {
        return isEmpty(str) ? "" : "\u202d" + str + "\u202c";
    }

    public static SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder == null ? new SpannableStringBuilder("") : new SpannableStringBuilder("\u202d").append((CharSequence) spannableStringBuilder).append((CharSequence) "\u202c");
    }

    public static String d(String str, int i, String str2) {
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

    @Deprecated
    public static String t(String str, int i) {
        return (str == null || i < 0 || str.length() == i) ? str : d(str, i - 1, "...");
    }

    public static String e(String str, int i, String str2) {
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

    public static String u(String str, int i) {
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

    public static int er(String str) {
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

    public static String f(String str, int i, String str2) {
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

    public static String O(long j) {
        return ((float) j) >= aXo ? String.format(Locale.getDefault(), "%.1fM", Float.valueOf(((float) j) / aXo)) : ((float) j) >= aXp / 10.0f ? String.format(Locale.getDefault(), "%.1fK", Float.valueOf(((float) j) / aXp)) : TbadkCoreApplication.getInst().getString(d.j.less_than_zero_dot_one_k);
    }

    public static int es(String str) {
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

    public static String P(long j) {
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= 100000000) {
            if (j % 100000000 != 0) {
                double d = ((float) j) / 1.0E8f;
                double d2 = j / 100000000;
                if (j % 100000000 > 999999.0d) {
                    return String.format("%.2f", Double.valueOf(d)) + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_yi);
                }
                return d2 + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_yi);
            }
            return (j / 100000000) + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_yi);
        } else if (j >= 1000000) {
            float f = ((float) j) / 10000.0f;
            long j2 = j / 10000;
            if (j % 1000000 > 999) {
                return String.format("%.2f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_wan);
            }
            return j2 + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_wan);
        } else {
            return valueOf;
        }
    }

    public static String Q(long j) {
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= 100000000) {
            if (j % 100000000 != 0) {
                double d = ((float) j) / 1.0E8f;
                double d2 = j / 100000000;
                if (j % 100000000 > 999999.0d) {
                    return String.format("%.2f", Double.valueOf(d)) + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_yi);
                }
                return d2 + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_yi);
            }
            return (j / 100000000) + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_yi);
        } else if (j >= 10000000) {
            float f = ((float) j) / 10000.0f;
            long j2 = j / 10000;
            if (j % 10000000 > 999) {
                return String.format("%.2f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_wan);
            }
            return j2 + TbadkCoreApplication.getInst().getResources().getString(d.j.unit_wan);
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
                return getFixedText(sb.toString(), i - 1, false) + "...";
            }
        }
        return sb.toString();
    }

    public static String R(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (aXy) {
            format = aXy.format(date2);
        }
        return format;
    }

    public static boolean equals(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static String S(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return String.valueOf(calendar.get(1));
    }

    public static String T(long j) {
        return S(j) + "年";
    }

    public static String U(long j) {
        int date2 = new Date(j).getDate();
        return date2 < 10 ? "0" + String.valueOf(date2) : String.valueOf(date2);
    }

    public static String V(long j) {
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

    public static boolean W(long j) {
        Time time = new Time();
        time.set(j);
        int i = time.year;
        int i2 = time.month;
        int i3 = time.monthDay;
        time.set(System.currentTimeMillis());
        return i == time.year && i2 == time.month && i3 == time.monthDay;
    }

    public static String fU(int i) {
        switch (i) {
            case 1:
                return TbadkCoreApplication.getInst().getContext().getString(d.j.he);
            case 2:
                return TbadkCoreApplication.getInst().getContext().getString(d.j.she);
            default:
                return TbadkCoreApplication.getInst().getContext().getString(d.j.he);
        }
    }

    public static String et(String str) {
        return str != null ? str.trim() : "";
    }

    public static String fV(int i) {
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
}
