package com.baidu.tbadk.core.util;

import android.graphics.Color;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.lib.util.i {
    private static long k = 86400000;
    private static long l = 3600000;
    private static long m = TbConfig.USE_TIME_INTERVAL;
    private static long n = 1000;
    private static String o = TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.time_hour_before);
    private static String p = TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.time_min_before);
    private static String q = TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.time_sec_before);
    private static Date r = new Date();

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        if (timeZone != null) {
            a.setTimeZone(timeZone);
            b.setTimeZone(timeZone);
            c.setTimeZone(timeZone);
            d.setTimeZone(timeZone);
            e.setTimeZone(timeZone);
            f.setTimeZone(timeZone);
            g.setTimeZone(timeZone);
            h.setTimeZone(timeZone);
            i.setTimeZone(timeZone);
            j.setTimeZone(timeZone);
        }
    }

    public static String a() {
        String format;
        Date date = new Date();
        synchronized (i) {
            format = i.format(date);
        }
        return format;
    }

    public static String a(int i, int i2, int i3) {
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

    public static int b() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(5) + 0 + (calendar.get(1) * TbConfig.BIG_IMAGE_MIN_CAPACITY) + ((calendar.get(2) + 1) * 100);
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
                synchronized (j) {
                    format2 = j.format(date2);
                }
                return format2;
            }
            synchronized (f) {
                format = f.format(date2);
            }
            return format;
        } else {
            return "刚刚";
        }
    }

    public static String f(String str) {
        return a(str);
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

    public static String a(long j) {
        String g;
        synchronized (r) {
            r.setTime(j);
            g = g(r);
        }
        return g;
    }

    private static String g(Date date) {
        if (date == null) {
            return "";
        }
        long time = new Date().getTime() - date.getTime();
        if (time < k && time > 0) {
            if (time < l) {
                if (time < m) {
                    long j = time / n;
                    if (j == 0) {
                        j = 1;
                    }
                    return String.valueOf(String.valueOf(j)) + q;
                }
                return String.valueOf(String.valueOf(time / m)) + p;
            }
            return String.valueOf(String.valueOf(time / l)) + o;
        }
        return d(date);
    }

    public static String b(long j) {
        String valueOf;
        Date date = new Date(j);
        if (date.getMinutes() < 10) {
            valueOf = "0" + date.getMinutes();
        } else {
            valueOf = String.valueOf(date.getMinutes());
        }
        return date.getHours() > 12 ? TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.time_show_afternoon, new Object[]{String.valueOf(date.getHours() - 12), valueOf}) : date.getHours() == 12 ? TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.time_show_afternoon, new Object[]{String.valueOf(date.getHours()), valueOf}) : date.getHours() == 0 ? TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.time_show_morning, new Object[]{String.valueOf(12), valueOf}) : TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.time_show_morning, new Object[]{String.valueOf(date.getHours()), valueOf});
    }
}
