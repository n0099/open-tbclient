package com.baidu.tbadk.core.util;

import android.graphics.Color;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.Character;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class bm {
    private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static SimpleDateFormat b = new SimpleDateFormat("yyyy年");
    private static SimpleDateFormat c = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat d = new SimpleDateFormat("M月d日");
    private static SimpleDateFormat e = new SimpleDateFormat("M月d日 HH:mm");
    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd E");
    private static SimpleDateFormat h = new SimpleDateFormat("yy-M-d");
    private static SimpleDateFormat i = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static SimpleDateFormat j = new SimpleDateFormat("yyyy-MM-dd");
    private static long k = 86400000;
    private static long l = 3600000;
    private static long m = TbConfig.USE_TIME_INTERVAL;
    private static long n = 1000;
    private static String o = TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.time_hour_before);
    private static String p = TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.time_min_before);
    private static String q = TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.time_sec_before);
    private static Date r = new Date();
    private static final char[] s;
    private static final char[] t;
    private static byte[] u;

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
        s = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        t = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
        u = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public static String a(Date date) {
        String format;
        synchronized (e) {
            format = e.format(date);
        }
        return format;
    }

    public static String b(Date date) {
        String format;
        synchronized (c) {
            format = c.format(date);
        }
        return format;
    }

    public static String c(Date date) {
        String format;
        synchronized (d) {
            format = d.format(date);
        }
        return format;
    }

    public static String d(Date date) {
        String format;
        synchronized (f) {
            format = f.format(date);
        }
        return format;
    }

    public static String a() {
        String format;
        Date date = new Date();
        synchronized (i) {
            format = i.format(date);
        }
        return format;
    }

    public static String a(int i2, int i3, int i4) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i2);
        calendar.set(2, i3);
        calendar.set(5, i4);
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
            long j2 = 30000 * 2;
            if (time < j2) {
                return "半分钟前";
            }
            long j3 = j2 * 60;
            if (time < j3) {
                return String.valueOf(String.valueOf((time * 60) / j3)) + "分钟前";
            }
            long j4 = j3 * 24;
            if (time < j4) {
                if (day == 0) {
                    return b(date2);
                }
                return "1天前";
            }
            long j5 = j4 * 31;
            if (time < j5) {
                return String.valueOf(String.valueOf((time * 31) / j5)) + "天前";
            }
            if (time < j5 + 86400000) {
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
            long j2 = 30000 * 2;
            if (time < j2) {
                return "半分钟前";
            }
            long j3 = j2 * 60;
            if (time < j3) {
                return String.valueOf(String.valueOf((time * 60) / j3)) + "分钟前";
            }
            long j4 = j3 * 24;
            if (time < j4) {
                if (day == 0) {
                    return b(date2);
                }
                return "1天前";
            }
            long j5 = j4 * 31;
            if (time < j5) {
                return String.valueOf(String.valueOf((time * 31) / j5)) + "天前";
            }
            if (time < j5 + 86400000) {
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

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(s[(bArr[i2] & 240) >>> 4]);
            sb.append(s[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    public static String a(InputStream inputStream) {
        String str = null;
        if (inputStream != null) {
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                str = a(messageDigest.digest());
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            } finally {
                com.baidu.adp.lib.util.m.a(inputStream);
            }
        }
        return str;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(new ByteArrayInputStream(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            return null;
        }
    }

    public static boolean a(char c2) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c2);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean b(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0 || str.equals("null");
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(String str, int i2) {
        if (str == null || i2 <= 0) {
            return String.valueOf("");
        }
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (a(str.charAt(i3))) {
                i4 += 2;
            } else {
                i4++;
            }
            if (i4 >= i2) {
                break;
            }
            i3++;
        }
        if (i3 < length) {
            return String.valueOf(str.substring(0, i3 + 1)) + "...";
        }
        return str;
    }

    public static String b(byte[] bArr) {
        int length = bArr.length;
        int i2 = 0;
        StringBuilder sb = new StringBuilder(length / 2);
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i3 == length) {
                sb.append(t[i4 >>> 2]);
                sb.append(t[(i4 & 3) << 4]);
                sb.append("==");
                break;
            }
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 == length) {
                sb.append(t[i4 >>> 2]);
                sb.append(t[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                sb.append(t[(i6 & 15) << 2]);
                sb.append("=");
                break;
            }
            i2 = i5 + 1;
            int i7 = bArr[i5] & 255;
            sb.append(t[i4 >>> 2]);
            sb.append(t[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
            sb.append(t[((i6 & 15) << 2) | ((i7 & 192) >>> 6)]);
            sb.append(t[i7 & 63]);
        }
        return sb.toString();
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
        } catch (Exception e2) {
            str2 = null;
            exc = e2;
        }
        try {
            return replaceAll.replaceAll("</em>", "</font>");
        } catch (Exception e3) {
            str2 = replaceAll;
            exc = e3;
            BdLog.e(exc.toString());
            return str2;
        }
    }

    public static String a(long j2) {
        String g2;
        synchronized (r) {
            r.setTime(j2);
            g2 = g(r);
        }
        return g2;
    }

    private static String g(Date date) {
        if (date == null) {
            return "";
        }
        long time = new Date().getTime() - date.getTime();
        if (time < k && time > 0) {
            if (time < l) {
                if (time < m) {
                    long j2 = time / n;
                    if (j2 == 0) {
                        j2 = 1;
                    }
                    return String.valueOf(String.valueOf(j2)) + q;
                }
                return String.valueOf(String.valueOf(time / m)) + p;
            }
            return String.valueOf(String.valueOf(time / l)) + o;
        }
        return d(date);
    }

    public static String b(long j2) {
        String valueOf;
        Date date = new Date(j2);
        if (date.getMinutes() < 10) {
            valueOf = "0" + date.getMinutes();
        } else {
            valueOf = String.valueOf(date.getMinutes());
        }
        return date.getHours() > 12 ? TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.time_show_afternoon, new Object[]{String.valueOf(date.getHours() - 12), valueOf}) : date.getHours() == 12 ? TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.time_show_afternoon, new Object[]{String.valueOf(date.getHours()), valueOf}) : date.getHours() == 0 ? TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.time_show_morning, new Object[]{String.valueOf(12), valueOf}) : TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.time_show_morning, new Object[]{String.valueOf(date.getHours()), valueOf});
    }
}
