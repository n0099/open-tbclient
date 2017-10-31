package com.baidu.tbadk.core.util;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.lib.util.k {
    private static long agY = 86400000;
    private static long agZ = 3600000;
    private static long aha = 60000;
    private static long ahb = 1000;
    private static float ahc = 1048576.0f;
    private static float ahd = 1024.0f;
    private static String ahe = TbadkCoreApplication.getInst().getApp().getString(d.j.time_hour_before);
    private static String ahf = TbadkCoreApplication.getInst().getApp().getString(d.j.time_min_before);
    private static String ahg = TbadkCoreApplication.getInst().getApp().getString(d.j.time_sec_before);
    private static String ahh = TbadkCoreApplication.getInst().getApp().getString(d.j.day);
    private static String ahi = TbadkCoreApplication.getInst().getApp().getString(d.j.time_hour);
    private static String ahj = TbadkCoreApplication.getInst().getApp().getString(d.j.time_minute);
    private static String ahk = TbadkCoreApplication.getInst().getApp().getString(d.j.time_second);
    private static final SimpleDateFormat ahl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat ahm = new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
    private static Date date = new Date();

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        if (timeZone != null) {
            yo.setTimeZone(timeZone);
            yp.setTimeZone(timeZone);
            yq.setTimeZone(timeZone);
            yr.setTimeZone(timeZone);
            ys.setTimeZone(timeZone);
            yt.setTimeZone(timeZone);
            yu.setTimeZone(timeZone);
            yv.setTimeZone(timeZone);
            yw.setTimeZone(timeZone);
            yx.setTimeZone(timeZone);
        }
    }

    public static String cU(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        sb.setLength(0);
        return i5 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public static String vp() {
        String format;
        Date date2 = new Date();
        synchronized (yw) {
            format = yw.format(date2);
        }
        return format;
    }

    public static String m(int i, int i2, int i3) {
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

    public static int vq() {
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
                synchronized (yx) {
                    format2 = yx.format(date3);
                }
                return format2;
            }
            synchronized (yt) {
                format = yt.format(date3);
            }
            return format;
        } else {
            return "刚刚";
        }
    }

    public static String p(long j) {
        long abs = Math.abs(System.currentTimeMillis() - (1000 * j));
        if (abs <= 120000) {
            return "刚刚";
        }
        if (abs >= Long.MAX_VALUE) {
            return "一个月前";
        }
        if (abs / agY != 0) {
            if (abs / agY > 30) {
                return "一个月前";
            }
            return (abs / agY) + "天前";
        } else if (abs / agZ != 0) {
            return (abs / agZ) + "小时前";
        } else {
            return (abs / aha) + "分钟前";
        }
    }

    public static String q(long j) {
        long abs = Math.abs(System.currentTimeMillis() - (1000 * j));
        if (abs <= 120000) {
            return "刚刚";
        }
        if (abs >= Long.MAX_VALUE || abs / agY != 0) {
            return "";
        }
        if (abs / agZ != 0) {
            return (abs / agZ) + "小时前";
        }
        return (abs / aha) + "分钟前";
    }

    public static String ad(String str, String str2) {
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

    public static String r(long j) {
        String a;
        synchronized (date) {
            date.setTime(j);
            a = a(date, false);
        }
        return a;
    }

    public static String s(long j) {
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
        if (time < agY && time > 0) {
            if (time < agZ) {
                if (time < aha) {
                    long j = time / ahb;
                    if (j == 0) {
                        j = 1;
                    }
                    return String.valueOf(j) + ahg;
                }
                return String.valueOf(time / aha) + ahf;
            }
            return String.valueOf(time / agZ) + ahe;
        } else if (z) {
            return g(date2);
        } else {
            return d(date2);
        }
    }

    public static String g(Date date2) {
        String format;
        synchronized (yx) {
            format = yx.format(date2);
        }
        return format;
    }

    public static String t(long j) {
        if (j <= 0) {
            return "1秒";
        }
        if (j < agY) {
            if (j < agZ) {
                if (j < aha) {
                    long j2 = j / ahb;
                    if (j2 == 0) {
                        j2 = 1;
                    }
                    return String.valueOf(j2) + ahk;
                }
                return String.valueOf(j / aha) + ahj;
            }
            return String.valueOf(j / agZ) + ahi;
        }
        return String.valueOf(j / agY) + ahh;
    }

    @Deprecated
    public static String cV(int i) {
        if (i > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(i / 10000.0f));
        }
        if (i < 0) {
            return "0";
        }
        return "" + i;
    }

    public static String u(long j) {
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

    public static String v(long j) {
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

    public static String w(long j) {
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

    public static String x(long j) {
        if (j > 9990000) {
            return "999W+";
        }
        if (j < 0) {
            return "0";
        }
        return "" + j;
    }

    public static String y(long j) {
        if (j > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(((float) j) / 10000.0f));
        }
        if (j < 0) {
            return "0";
        }
        return "" + j;
    }

    public static String z(long j) {
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

    public static String A(long j) {
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

    public static String B(long j) {
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

    public static String C(long j) {
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

    public static String D(long j) {
        if (j > 9999) {
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

    public static String cW(int i) {
        return new DecimalFormat("#,###").format(i);
    }

    public static String formatTosepara(long j) {
        return new DecimalFormat("#,###").format(j);
    }

    public static String E(long j) {
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

    public static String F(long j) {
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

    public static String dR(String str) {
        return isEmpty(str) ? "" : "\u202d" + str + "\u202c";
    }

    public static SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder == null ? new SpannableStringBuilder("") : new SpannableStringBuilder("\u202d").append((CharSequence) spannableStringBuilder).append((CharSequence) "\u202c");
    }

    public static String vr() {
        return "-∞";
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

    public static String s(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (i > 0) {
            try {
                if (str.codePointCount(0, str.length()) > i) {
                    return str.substring(0, str.offsetByCodePoints(0, i - 1)) + "...";
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

    public static int dS(String str) {
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

    public static String G(long j) {
        return ((float) j) >= ahc ? String.format(Locale.getDefault(), "%.1fM", Float.valueOf(((float) j) / ahc)) : ((float) j) >= ahd / 10.0f ? String.format(Locale.getDefault(), "%.1fK", Float.valueOf(((float) j) / ahd)) : TbadkCoreApplication.getInst().getString(d.j.less_than_zero_dot_one_k);
    }

    public static int dT(String str) {
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

    public static String H(long j) {
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

    public static String I(long j) {
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

    public static String J(long j) {
        String format;
        Date date2 = new Date(j);
        synchronized (ahm) {
            format = ahm.format(date2);
        }
        return format;
    }

    public static boolean equals(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static String K(long j) {
        int date2 = new Date(j).getDate();
        return date2 < 10 ? "0" + String.valueOf(date2) : String.valueOf(date2);
    }

    public static String L(long j) {
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

    public static String cX(int i) {
        switch (i) {
            case 1:
                return TbadkCoreApplication.getInst().getContext().getString(d.j.he);
            case 2:
                return TbadkCoreApplication.getInst().getContext().getString(d.j.she);
            default:
                return TbadkCoreApplication.getInst().getContext().getString(d.j.he);
        }
    }

    public static String dU(String str) {
        return str != null ? str.trim() : "";
    }

    public static String cY(int i) {
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
