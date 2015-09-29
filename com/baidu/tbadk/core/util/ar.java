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
import com.baidu.tieba.i;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.lib.util.j {
    private static long aaZ = 86400000;
    private static long aba = 3600000;
    private static long abb = TbConfig.USE_TIME_INTERVAL;
    private static long abc = 1000;
    private static float abd = 1048576.0f;
    private static float abe = 1024.0f;
    private static String abf = TbadkCoreApplication.m411getInst().getApp().getString(i.h.time_hour_before);
    private static String abg = TbadkCoreApplication.m411getInst().getApp().getString(i.h.time_min_before);
    private static String abh = TbadkCoreApplication.m411getInst().getApp().getString(i.h.time_sec_before);
    private static Date abi = new Date();

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        if (timeZone != null) {
            yp.setTimeZone(timeZone);
            yq.setTimeZone(timeZone);
            yr.setTimeZone(timeZone);
            ys.setTimeZone(timeZone);
            yt.setTimeZone(timeZone);
            yu.setTimeZone(timeZone);
            yv.setTimeZone(timeZone);
            yw.setTimeZone(timeZone);
            yx.setTimeZone(timeZone);
            yy.setTimeZone(timeZone);
        }
    }

    public static String uF() {
        String format;
        Date date = new Date();
        synchronized (yx) {
            format = yx.format(date);
        }
        return format;
    }

    public static String p(int i, int i2, int i3) {
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

    public static int uG() {
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
                synchronized (yy) {
                    format2 = yy.format(date2);
                }
                return format2;
            }
            synchronized (yu) {
                format = yu.format(date2);
            }
            return format;
        } else {
            return "刚刚";
        }
    }

    public static String n(long j) {
        long abs = Math.abs(System.currentTimeMillis() - (1000 * j));
        if (abs <= 120000) {
            return "刚刚";
        }
        if (abs >= Long.MAX_VALUE) {
            return "一个月前";
        }
        if (abs / aaZ != 0) {
            if (abs / aaZ > 30) {
                return "一个月前";
            }
            return String.valueOf(abs / aaZ) + "天前";
        } else if (abs / aba != 0) {
            return String.valueOf(abs / aba) + "小时前";
        } else {
            return String.valueOf(abs / abb) + "分钟前";
        }
    }

    public static String af(String str, String str2) {
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

    public static String o(long j) {
        String g;
        synchronized (abi) {
            abi.setTime(j);
            g = g(abi);
        }
        return g;
    }

    private static String g(Date date) {
        if (date == null) {
            return "";
        }
        long time = new Date().getTime() - date.getTime();
        if (time < aaZ && time > 0) {
            if (time < aba) {
                if (time < abb) {
                    long j = time / abc;
                    if (j == 0) {
                        j = 1;
                    }
                    return String.valueOf(String.valueOf(j)) + abh;
                }
                return String.valueOf(String.valueOf(time / abb)) + abg;
            }
            return String.valueOf(String.valueOf(time / aba)) + abf;
        }
        return d(date);
    }

    public static String p(long j) {
        String valueOf;
        Date date = new Date(j);
        if (date.getMinutes() < 10) {
            valueOf = "0" + date.getMinutes();
        } else {
            valueOf = String.valueOf(date.getMinutes());
        }
        return date.getHours() > 12 ? TbadkCoreApplication.m411getInst().getApp().getString(i.h.time_show_afternoon, new Object[]{String.valueOf(date.getHours() - 12), valueOf}) : date.getHours() == 12 ? TbadkCoreApplication.m411getInst().getApp().getString(i.h.time_show_afternoon, new Object[]{String.valueOf(date.getHours()), valueOf}) : date.getHours() == 0 ? TbadkCoreApplication.m411getInst().getApp().getString(i.h.time_show_morning, new Object[]{String.valueOf(12), valueOf}) : TbadkCoreApplication.m411getInst().getApp().getString(i.h.time_show_morning, new Object[]{String.valueOf(date.getHours()), valueOf});
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
    @Deprecated
    public static String cA(int i) {
        if (i > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(i / 10000.0f));
        }
        if (i < 0) {
            return "0";
        }
        return new StringBuilder().append(i).toString();
    }

    public static String q(long j) {
        if (j >= 10000000) {
            return u(j);
        }
        if (j >= 10000) {
            return r(j);
        }
        if (j >= 0) {
            return new StringBuilder(String.valueOf(j)).toString();
        }
        return "";
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 long)] */
    public static String r(long j) {
        if (j > 9999) {
            return String.valueOf((int) (((float) j) / 10000.0f)) + "w";
        }
        if (j < 0) {
            return "0";
        }
        return new StringBuilder().append(j).toString();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 long)] */
    public static String s(long j) {
        if (j > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(((float) j) / 10000.0f));
        }
        if (j < 0) {
            return "0";
        }
        return new StringBuilder().append(j).toString();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 long)] */
    public static String t(long j) {
        if (j > 9999999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return String.valueOf(round) + "w";
        } else if (j < 0) {
            return "0";
        } else {
            return new StringBuilder().append(j).toString();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 long)] */
    public static String u(long j) {
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
    public static String v(long j) {
        if (j > 9999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return String.valueOf(round) + "w";
        } else if (j < 0) {
            return "0";
        } else {
            return new StringBuilder().append(j).toString();
        }
    }

    public static String w(long j) {
        float f;
        long j2;
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= 1000000) {
            if (((float) j) / 10000.0f > ((float) (j / 10000))) {
                return String.valueOf(String.format("%.1f", Float.valueOf(f))) + TbadkCoreApplication.m411getInst().getResources().getString(i.h.unit_wan);
            }
            return String.valueOf(j2) + TbadkCoreApplication.m411getInst().getResources().getString(i.h.unit_wan);
        }
        return valueOf;
    }

    public static String x(long j) {
        if (j < 0) {
            return "0";
        }
        if (j > 99990000) {
            return "9999w+";
        }
        if (j > 9999) {
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            float f = ((float) j) / 10000.0f;
            if (f < 1000.0f) {
                return String.valueOf(decimalFormat.format(f)) + "w";
            }
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return String.valueOf(round) + "w";
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
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(i)), lastIndexOf, str2.length() + lastIndexOf, 33);
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

    public static String dl(String str) {
        return isEmpty(str) ? "" : "\u202d" + str + "\u202c";
    }

    public static SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder == null ? new SpannableStringBuilder("") : new SpannableStringBuilder("\u202d").append((CharSequence) spannableStringBuilder).append((CharSequence) "\u202c");
    }

    public static String uH() {
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

    public static String y(long j) {
        return ((float) j) >= abd ? String.format(Locale.getDefault(), "%.1fM", Float.valueOf(((float) j) / abd)) : ((float) j) >= abe / 10.0f ? String.format(Locale.getDefault(), "%.1fK", Float.valueOf(((float) j) / abe)) : TbadkCoreApplication.m411getInst().getString(i.h.less_than_zero_dot_one_k);
    }
}
