package com.baidu.tbadk.core.util;

import android.graphics.Color;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.game.GameInfoData;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.lib.util.m {
    private static long Vo = 86400000;
    private static long Vp = 3600000;
    private static long Vq = TbConfig.USE_TIME_INTERVAL;
    private static long Vr = 1000;
    private static String Vs = TbadkCoreApplication.m411getInst().getApp().getString(com.baidu.tieba.y.time_hour_before);
    private static String Vt = TbadkCoreApplication.m411getInst().getApp().getString(com.baidu.tieba.y.time_min_before);
    private static String Vu = TbadkCoreApplication.m411getInst().getApp().getString(com.baidu.tieba.y.time_sec_before);
    private static Date Vv = new Date();

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        if (timeZone != null) {
            yC.setTimeZone(timeZone);
            yD.setTimeZone(timeZone);
            yE.setTimeZone(timeZone);
            yF.setTimeZone(timeZone);
            yG.setTimeZone(timeZone);
            yH.setTimeZone(timeZone);
            yI.setTimeZone(timeZone);
            yJ.setTimeZone(timeZone);
            yK.setTimeZone(timeZone);
            yL.setTimeZone(timeZone);
        }
    }

    public static String sW() {
        String format;
        Date date = new Date();
        synchronized (yK) {
            format = yK.format(date);
        }
        return format;
    }

    public static String q(int i, int i2, int i3) {
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

    public static int sX() {
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
                synchronized (yL) {
                    format2 = yL.format(date2);
                }
                return format2;
            }
            synchronized (yH) {
                format = yH.format(date2);
            }
            return format;
        } else {
            return "刚刚";
        }
    }

    public static String m(long j) {
        long abs = Math.abs(System.currentTimeMillis() - (1000 * j));
        if (abs <= 120000) {
            return "刚刚";
        }
        if (abs >= Long.MAX_VALUE) {
            return "一个月前";
        }
        if (abs / Vo != 0) {
            if (abs / Vo > 30) {
                return "一个月前";
            }
            return String.valueOf(abs / Vo) + "天前";
        } else if (abs / Vp != 0) {
            return String.valueOf(abs / Vp) + "小时前";
        } else {
            return String.valueOf(abs / Vq) + "分钟前";
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

    public static String n(long j) {
        String g;
        synchronized (Vv) {
            Vv.setTime(j);
            g = g(Vv);
        }
        return g;
    }

    private static String g(Date date) {
        if (date == null) {
            return "";
        }
        long time = new Date().getTime() - date.getTime();
        if (time < Vo && time > 0) {
            if (time < Vp) {
                if (time < Vq) {
                    long j = time / Vr;
                    if (j == 0) {
                        j = 1;
                    }
                    return String.valueOf(String.valueOf(j)) + Vu;
                }
                return String.valueOf(String.valueOf(time / Vq)) + Vt;
            }
            return String.valueOf(String.valueOf(time / Vp)) + Vs;
        }
        return d(date);
    }

    public static String o(long j) {
        String valueOf;
        Date date = new Date(j);
        if (date.getMinutes() < 10) {
            valueOf = GameInfoData.NOT_FROM_DETAIL + date.getMinutes();
        } else {
            valueOf = String.valueOf(date.getMinutes());
        }
        return date.getHours() > 12 ? TbadkCoreApplication.m411getInst().getApp().getString(com.baidu.tieba.y.time_show_afternoon, new Object[]{String.valueOf(date.getHours() - 12), valueOf}) : date.getHours() == 12 ? TbadkCoreApplication.m411getInst().getApp().getString(com.baidu.tieba.y.time_show_afternoon, new Object[]{String.valueOf(date.getHours()), valueOf}) : date.getHours() == 0 ? TbadkCoreApplication.m411getInst().getApp().getString(com.baidu.tieba.y.time_show_morning, new Object[]{String.valueOf(12), valueOf}) : TbadkCoreApplication.m411getInst().getApp().getString(com.baidu.tieba.y.time_show_morning, new Object[]{String.valueOf(date.getHours()), valueOf});
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
    @Deprecated
    public static String ch(int i) {
        if (i > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(i / 10000.0f));
        }
        if (i < 0) {
            return GameInfoData.NOT_FROM_DETAIL;
        }
        return new StringBuilder().append(i).toString();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 long)] */
    public static String p(long j) {
        if (j > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(((float) j) / 10000.0f));
        }
        if (j < 0) {
            return GameInfoData.NOT_FROM_DETAIL;
        }
        return new StringBuilder().append(j).toString();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 long)] */
    public static String q(long j) {
        if (j > 9999999) {
            float f = ((float) j) / 10000.0f;
            long round = Math.round(f);
            if (((float) round) > f) {
                round--;
            }
            return String.valueOf(round) + "w";
        } else if (j < 0) {
            return GameInfoData.NOT_FROM_DETAIL;
        } else {
            return new StringBuilder().append(j).toString();
        }
    }
}
