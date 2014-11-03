package com.baidu.tbadk.core.util;

import android.graphics.Color;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.lib.util.l {
    private static long Fa = 86400000;
    private static long Fb = 3600000;
    private static long Fc = TbConfig.USE_TIME_INTERVAL;
    private static long Fd = 1000;
    private static String Fe = TbadkApplication.m251getInst().getApp().getString(com.baidu.tieba.y.time_hour_before);
    private static String Ff = TbadkApplication.m251getInst().getApp().getString(com.baidu.tieba.y.time_min_before);
    private static String Fg = TbadkApplication.m251getInst().getApp().getString(com.baidu.tieba.y.time_sec_before);
    private static Date Fh = new Date();

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        if (timeZone != null) {
            na.setTimeZone(timeZone);
            nb.setTimeZone(timeZone);
            nc.setTimeZone(timeZone);
            nd.setTimeZone(timeZone);
            ne.setTimeZone(timeZone);
            nf.setTimeZone(timeZone);
            ng.setTimeZone(timeZone);
            nh.setTimeZone(timeZone);
            ni.setTimeZone(timeZone);
            nj.setTimeZone(timeZone);
        }
    }

    public static String e(Date date) {
        String format;
        synchronized (nh) {
            format = nh.format(date);
        }
        return format;
    }

    public static String mB() {
        String format;
        Date date = new Date();
        synchronized (ni) {
            format = ni.format(date);
        }
        return format;
    }

    public static String l(int i, int i2, int i3) {
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

    public static int mC() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(5) + 0 + (calendar.get(1) * TbConfig.BIG_IMAGE_MIN_CAPACITY) + ((calendar.get(2) + 1) * 100);
    }

    public static String f(Date date) {
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

    public static String g(Date date) {
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
                synchronized (nj) {
                    format2 = nj.format(date2);
                }
                return format2;
            }
            synchronized (nf) {
                format = nf.format(date2);
            }
            return format;
        } else {
            return "刚刚";
        }
    }

    public static String i(long j) {
        long abs = Math.abs(System.currentTimeMillis() - (1000 * j));
        if (abs <= 120000) {
            return "刚刚";
        }
        if (abs >= Long.MAX_VALUE) {
            return "一个月前";
        }
        if (abs / Fa != 0) {
            if (abs / Fa > 30) {
                return "一个月前";
            }
            return String.valueOf(abs / Fa) + "天前";
        } else if (abs / Fb != 0) {
            return String.valueOf(abs / Fb) + "小时前";
        } else {
            return String.valueOf(abs / Fc) + "分钟前";
        }
    }

    public static String a(String str, Color color) {
        String str2;
        Exception exc;
        String replaceAll;
        if (str == null) {
            return "";
        }
        try {
            replaceAll = str.replaceAll("<em>", "<font color='#007bd1'>");
        } catch (Exception e) {
            str2 = null;
            exc = e;
        }
        try {
            return replaceAll.replaceAll("</em>", "</font>");
        } catch (Exception e2) {
            str2 = replaceAll;
            exc = e2;
            BdLog.e(exc.toString());
            return str2;
        }
    }

    public static String j(long j) {
        String h;
        synchronized (Fh) {
            Fh.setTime(j);
            h = h(Fh);
        }
        return h;
    }

    private static String h(Date date) {
        if (date == null) {
            return "";
        }
        long time = new Date().getTime() - date.getTime();
        if (time < Fa && time > 0) {
            if (time < Fb) {
                if (time < Fc) {
                    long j = time / Fd;
                    if (j == 0) {
                        j = 1;
                    }
                    return String.valueOf(String.valueOf(j)) + Fg;
                }
                return String.valueOf(String.valueOf(time / Fc)) + Ff;
            }
            return String.valueOf(String.valueOf(time / Fb)) + Fe;
        }
        return d(date);
    }

    public static String k(long j) {
        String valueOf;
        Date date = new Date(j);
        if (date.getMinutes() < 10) {
            valueOf = "0" + date.getMinutes();
        } else {
            valueOf = String.valueOf(date.getMinutes());
        }
        return date.getHours() > 12 ? TbadkApplication.m251getInst().getApp().getString(com.baidu.tieba.y.time_show_afternoon, new Object[]{String.valueOf(date.getHours() - 12), valueOf}) : date.getHours() == 12 ? TbadkApplication.m251getInst().getApp().getString(com.baidu.tieba.y.time_show_afternoon, new Object[]{String.valueOf(date.getHours()), valueOf}) : date.getHours() == 0 ? TbadkApplication.m251getInst().getApp().getString(com.baidu.tieba.y.time_show_morning, new Object[]{String.valueOf(12), valueOf}) : TbadkApplication.m251getInst().getApp().getString(com.baidu.tieba.y.time_show_morning, new Object[]{String.valueOf(date.getHours()), valueOf});
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
    public static String bB(int i) {
        if (i > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(i / 10000.0f));
        }
        if (i < 0) {
            return "0";
        }
        return new StringBuilder().append(i).toString();
    }
}
