package com.baidu.tbadk.core.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.lib.util.j {
    private static long XY = 86400000;
    private static long XZ = 3600000;
    private static long Ya = TbConfig.USE_TIME_INTERVAL;
    private static long Yb = 1000;
    private static float Yc = 1048576.0f;
    private static float Yd = 1024.0f;
    private static String Ye = TbadkCoreApplication.m9getInst().getApp().getString(u.j.time_hour_before);
    private static String Yf = TbadkCoreApplication.m9getInst().getApp().getString(u.j.time_min_before);
    private static String Yg = TbadkCoreApplication.m9getInst().getApp().getString(u.j.time_sec_before);
    private static String Yh = TbadkCoreApplication.m9getInst().getApp().getString(u.j.time_day);
    private static String Yi = TbadkCoreApplication.m9getInst().getApp().getString(u.j.time_hour);
    private static String Yj = TbadkCoreApplication.m9getInst().getApp().getString(u.j.time_minute);
    private static String Yk = TbadkCoreApplication.m9getInst().getApp().getString(u.j.time_second);
    private static final SimpleDateFormat Yl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat Ym = new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
    private static Date Yn = new Date();

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        if (timeZone != null) {
            pe.setTimeZone(timeZone);
            pf.setTimeZone(timeZone);
            pg.setTimeZone(timeZone);
            ph.setTimeZone(timeZone);
            pi.setTimeZone(timeZone);
            pj.setTimeZone(timeZone);
            pl.setTimeZone(timeZone);
            po.setTimeZone(timeZone);
            pp.setTimeZone(timeZone);
            pq.setTimeZone(timeZone);
        }
    }

    public static String ub() {
        String format;
        Date date = new Date();
        synchronized (pp) {
            format = pp.format(date);
        }
        return format;
    }

    public static String w(long j) {
        int i = (int) (j / 3600000);
        if (i >= 24) {
            return String.valueOf((i / 24) + 1) + Yh;
        }
        return String.valueOf(i + 1) + Yi;
    }

    public static String uc() {
        String format;
        Date date = new Date();
        synchronized (pj) {
            format = pj.format(date);
        }
        return format;
    }

    public static String n(int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        switch (calendar.get(7)) {
            case 1:
                return String.valueOf("周") + "日";
            case 2:
                return String.valueOf("周") + "一";
            case 3:
                return String.valueOf("周") + "二";
            case 4:
                return String.valueOf("周") + "三";
            case 5:
                return String.valueOf("周") + "四";
            case 6:
                return String.valueOf("周") + "五";
            case 7:
                return String.valueOf("周") + "六";
            default:
                return "周";
        }
    }

    public static int ud() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(5) + 0 + (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100);
    }

    public static String e(Date date) {
        return date == null ? "" : a(new Date(), date);
    }

    public static String a(Date date, Date date2) {
        if (date2 == null) {
            return "";
        }
        int day = date.getDay() - date2.getDay();
        long time = date.getTime() - date2.getTime();
        if (time < 0) {
            if (time > -120000) {
                return "刚刚";
            }
            return d(date2);
        } else if (time >= 30000) {
            long j = 30000 * 2;
            if (time < j) {
                return "半分钟前";
            }
            long j2 = j * 60;
            if (time < j2) {
                return String.valueOf(String.valueOf((time * 60) / j2)) + "分钟前";
            }
            long j3 = j2 * 24;
            if (time < j3) {
                if (day == 0) {
                    return b(date2);
                }
                return "1天前";
            }
            long j4 = j3 * 31;
            if (time < j4) {
                return String.valueOf(String.valueOf((time * 31) / j4)) + "天前";
            }
            if (time < j4 + 86400000) {
                return "1个月前";
            }
            return d(date2);
        } else {
            return "刚刚";
        }
    }

    public static String f(Date date) {
        return b(new Date(), date);
    }

    public static String b(Date date, Date date2) {
        String format;
        String format2;
        if (date2 == null) {
            return "";
        }
        int day = date.getDay() - date2.getDay();
        long time = date.getTime() - date2.getTime();
        if (time < 0) {
            if (time > -120000) {
                return "刚刚";
            }
            return d(date2);
        } else if (time >= 30000) {
            long j = 30000 * 2;
            if (time < j) {
                return "半分钟前";
            }
            long j2 = j * 60;
            if (time < j2) {
                return String.valueOf(String.valueOf((time * 60) / j2)) + "分钟前";
            }
            long j3 = j2 * 24;
            if (time < j3) {
                if (day == 0) {
                    return b(date2);
                }
                return "1天前";
            }
            long j4 = j3 * 31;
            if (time < j4) {
                return String.valueOf(String.valueOf((time * 31) / j4)) + "天前";
            }
            if (time < j4 + 86400000) {
                return "1个月前";
            }
            if (date.getYear() == date2.getYear()) {
                synchronized (pq) {
                    format2 = pq.format(date2);
                }
                return format2;
            }
            synchronized (pj) {
                format = pj.format(date2);
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
        if (abs / XY != 0) {
            if (abs / XY > 30) {
                return "一个月前";
            }
            return String.valueOf(abs / XY) + "天前";
        } else if (abs / XZ != 0) {
            return String.valueOf(abs / XZ) + "小时前";
        } else {
            return String.valueOf(abs / Ya) + "分钟前";
        }
    }

    public static String ad(String str, String str2) {
        String str3;
        Exception exc;
        String replaceAll;
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (StringUtils.isNull(str2)) {
            str2 = "#007bd1";
        }
        try {
            replaceAll = str.replaceAll("<em>", "<font color='" + str2 + "'>");
        } catch (Exception e) {
            str3 = null;
            exc = e;
        }
        try {
            return replaceAll.replaceAll("</em>", "</font>");
        } catch (Exception e2) {
            str3 = replaceAll;
            exc = e2;
            BdLog.e(exc.toString());
            return str3;
        }
    }

    public static String y(long j) {
        String a;
        synchronized (Yn) {
            Yn.setTime(j);
            a = a(Yn, false);
        }
        return a;
    }

    public static String z(long j) {
        String a;
        synchronized (Yn) {
            Yn.setTime(j);
            a = a(Yn, true);
        }
        return a;
    }

    private static String a(Date date, boolean z) {
        if (date == null) {
            return "";
        }
        long time = new Date().getTime() - date.getTime();
        if (time < XY && time > 0) {
            if (time < XZ) {
                if (time < Ya) {
                    long j = time / Yb;
                    if (j == 0) {
                        j = 1;
                    }
                    return String.valueOf(String.valueOf(j)) + Yg;
                }
                return String.valueOf(String.valueOf(time / Ya)) + Yf;
            }
            return String.valueOf(String.valueOf(time / XZ)) + Ye;
        } else if (z) {
            return g(date);
        } else {
            return d(date);
        }
    }

    public static String g(Date date) {
        String format;
        synchronized (pq) {
            format = pq.format(date);
        }
        return format;
    }

    public static String A(long j) {
        if (j <= 0) {
            return "1秒";
        }
        if (j < XY) {
            if (j < XZ) {
                if (j < Ya) {
                    long j2 = j / Yb;
                    if (j2 == 0) {
                        j2 = 1;
                    }
                    return String.valueOf(String.valueOf(j2)) + Yk;
                }
                return String.valueOf(String.valueOf(j / Ya)) + Yj;
            }
            return String.valueOf(String.valueOf(j / XZ)) + Yi;
        }
        return String.valueOf(String.valueOf(j / XY)) + Yh;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
    @Deprecated
    public static String cD(int i) {
        if (i > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(i / 10000.0f));
        }
        if (i < 0) {
            return "0";
        }
        return new StringBuilder().append(i).toString();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v0 int)] */
    public static String cE(int i) {
        if (i > 1000) {
            return "999+";
        }
        if (i < 0) {
            return "0";
        }
        return new StringBuilder().append(i).toString();
    }

    public static String B(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return new StringBuilder(String.valueOf(j)).toString();
        }
        if (j < 10000000) {
            float f = ((float) (j / 1000)) / 10.0f;
            if (f % 1.0f == 0.0f) {
                return String.valueOf((int) f) + "W";
            }
            return String.valueOf(f) + "W";
        }
        float f2 = ((float) (j / 1000000)) / 10.0f;
        if (f2 % 1.0f == 0.0f) {
            return String.valueOf((int) f2) + "KW";
        }
        return String.valueOf(f2) + "KW";
    }

    public static String C(long j) {
        if (j <= 0) {
            return "0";
        }
        if (j < 10000) {
            return new StringBuilder(String.valueOf(j)).toString();
        }
        if (j < 10000000) {
            float f = ((float) (j / 1000)) / 10.0f;
            if (f % 1.0f == 0.0f) {
                return String.valueOf((int) f) + "W";
            }
            return String.valueOf(f) + "W";
        }
        float f2 = ((float) (j / 1000000)) / 10.0f;
        if (f2 >= 9999.0f) {
            return "9999KW+";
        }
        if (f2 % 1.0f == 0.0f) {
            return String.valueOf((int) f2) + "KW";
        }
        return String.valueOf(f2) + "KW";
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 long)] */
    public static String D(long j) {
        if (j > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(((float) j) / 10000.0f));
        }
        if (j < 0) {
            return "0";
        }
        return new StringBuilder().append(j).toString();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 long)] */
    public static String E(long j) {
        if (j > 99990000) {
            return "9999W+";
        }
        if (j >= 1000000) {
            return String.valueOf(String.valueOf(j / 10000)) + "W";
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
        return new StringBuilder().append(j).toString();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 long)] */
    public static String F(long j) {
        if (j > 9999999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return String.valueOf(round) + "W";
        } else if (j < 0) {
            return "0";
        } else {
            return new StringBuilder().append(j).toString();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 long)] */
    public static String G(long j) {
        if (j > 9999999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return round >= 9999 ? "9999W+" : String.valueOf(j) + "W";
        } else if (j < 0) {
            return "0";
        } else {
            return new StringBuilder().append(j).toString();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 long)] */
    public static String H(long j) {
        if (j > 9999999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return String.valueOf(round) + "w+";
        } else if (j < 0) {
            return "0";
        } else {
            return new StringBuilder().append(j).toString();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 long)] */
    public static String I(long j) {
        if (j > 9999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return String.valueOf(round) + "W";
        } else if (j < 0) {
            return "0";
        } else {
            return new StringBuilder().append(j).toString();
        }
    }

    public static String J(long j) {
        float f;
        long j2;
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= 100000000) {
            if (j % 100000000 != 0) {
                return String.valueOf(String.format("%.1f", Double.valueOf(((float) j) / 1.0E8f))) + TbadkCoreApplication.m9getInst().getResources().getString(u.j.unit_yi);
            }
            return String.valueOf(j / 100000000) + TbadkCoreApplication.m9getInst().getResources().getString(u.j.unit_yi);
        } else if (j >= 1000000) {
            if (((float) j) / 10000.0f > ((float) (j / 10000))) {
                return String.valueOf(String.format("%.1f", Float.valueOf(f))) + TbadkCoreApplication.m9getInst().getResources().getString(u.j.unit_wan);
            }
            return String.valueOf(j2) + TbadkCoreApplication.m9getInst().getResources().getString(u.j.unit_wan);
        } else {
            return valueOf;
        }
    }

    public static String K(long j) {
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
                return String.valueOf(decimalFormat.format(f)) + "W";
            }
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return String.valueOf(round) + "W";
        }
        return String.valueOf(j);
    }

    public static SpannableString a(Context context, String str, String str2, int i, boolean z) {
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
        spannableString.setSpan(new ForegroundColorSpan(av.getColor(i)), lastIndexOf, str2.length() + lastIndexOf, 33);
        return spannableString;
    }

    public static String a(long j, String str) {
        Date date;
        if (String.valueOf(j).length() == 10) {
            date = new Date(1000 * j);
        } else {
            date = new Date(j);
        }
        return new SimpleDateFormat(str).format(date);
    }

    public static String dz(String str) {
        return isEmpty(str) ? "" : "\u202d" + str + "\u202c";
    }

    public static SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder == null ? new SpannableStringBuilder("") : new SpannableStringBuilder("\u202d").append((CharSequence) spannableStringBuilder).append((CharSequence) "\u202c");
    }

    public static String ue() {
        return "-∞";
    }

    public static String c(String str, int i, String str2) {
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

    public static String t(String str, int i) {
        return (str == null || i < 0 || str.length() == i) ? str : c(str, i - 1, "...");
    }

    public static String d(String str, int i, String str2) {
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
            if (str2 == null) {
                str2 = "";
            }
            return String.valueOf(str.substring(0, i2 + 1)) + str2;
        }
        return str;
    }

    public static String L(long j) {
        return ((float) j) >= Yc ? String.format(Locale.getDefault(), "%.1fM", Float.valueOf(((float) j) / Yc)) : ((float) j) >= Yd / 10.0f ? String.format(Locale.getDefault(), "%.1fK", Float.valueOf(((float) j) / Yd)) : TbadkCoreApplication.m9getInst().getString(u.j.less_than_zero_dot_one_k);
    }

    public static int dA(String str) {
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

    public static String M(long j) {
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= 100000000) {
            if (j % 100000000 != 0) {
                double d = ((float) j) / 1.0E8f;
                double d2 = j / 100000000;
                if (j % 100000000 > 999999.0d) {
                    return String.valueOf(String.format("%.2f", Double.valueOf(d))) + TbadkCoreApplication.m9getInst().getResources().getString(u.j.unit_yi);
                }
                return String.valueOf(d2) + TbadkCoreApplication.m9getInst().getResources().getString(u.j.unit_yi);
            }
            return String.valueOf(j / 100000000) + TbadkCoreApplication.m9getInst().getResources().getString(u.j.unit_yi);
        } else if (j >= 1000000) {
            float f = ((float) j) / 10000.0f;
            long j2 = j / 10000;
            if (j % 1000000 > 999) {
                return String.valueOf(String.format("%.2f", Float.valueOf(f))) + TbadkCoreApplication.m9getInst().getResources().getString(u.j.unit_wan);
            }
            return String.valueOf(j2) + TbadkCoreApplication.m9getInst().getResources().getString(u.j.unit_wan);
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
                return String.valueOf(getFixedText(sb.toString(), i - 1, false)) + "...";
            }
        }
        return sb.toString();
    }

    public static String N(long j) {
        String format;
        Date date = new Date(j);
        synchronized (Ym) {
            format = Ym.format(date);
        }
        return format;
    }
}
