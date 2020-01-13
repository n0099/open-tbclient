package com.baidu.android.util.time;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes12.dex */
public final class DateTimeUtil {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_CN = "yyyy年MM月dd日";
    public static final String DAY_FORMAT = "yyyyMMdd";
    public static final String DAY_FORMAT_MONTH_CN = "MM月dd日";
    private static final String MD = "MM-dd";
    public static final int MODE_NEXT_NORMAL_DAY = 1;
    public static final int MODE_NEXT_WEEKEND = 3;
    public static final int MODE_NEXT_WORKDAY = 2;
    public static final String MONTH_FORMAT = "yyyy-MM";
    public static final int TIME_DAY_MILLISECOND = 86400000;
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";
    private static final String Y4MD = "yyyy-MM-dd";
    private static final String Y4MD_HM = "yyyy-MM-dd HH:mm";
    public static final String YEAR_FORMAT = "yyyy";
    private static long MSEC_OF_ONE_DAY = 86400000;
    private static long MSEC_OF_ONE_HOUR = BdKVCache.MILLS_1Hour;
    private static long MSEC_OF_ONE_MINUTE = 60000;
    private static long MSEC_OF_ONE_SEC = 1000;
    private static long mDelta = 0;
    private static long SECONDUNIT = 1000;
    private static final Set<Integer> WORK_DAY = new HashSet();
    private static final Set<Integer> WEEKEND_DAY = new HashSet();
    private static final Set<Integer> NORMAL_DAY = new HashSet();

    static {
        WORK_DAY.add(2);
        WORK_DAY.add(3);
        WORK_DAY.add(4);
        WORK_DAY.add(5);
        WORK_DAY.add(6);
        WEEKEND_DAY.add(7);
        WEEKEND_DAY.add(1);
        NORMAL_DAY.addAll(WORK_DAY);
        NORMAL_DAY.addAll(WEEKEND_DAY);
    }

    private DateTimeUtil() {
    }

    public static Date getCurrDate() {
        return new Date();
    }

    public static Timestamp getCurrTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getFormatDate(Date date, String str) {
        if (date == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(str).format(date);
        } catch (Exception e) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").format(date);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static Date getFormatDate(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (Exception e) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static Date getFormatDate(String str, String[] strArr) {
        Date date = null;
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                try {
                    date = new SimpleDateFormat(str2).parse(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (date != null) {
                    break;
                }
            }
        }
        return date;
    }

    public static String getFormatDateTime(Date date, String str) {
        if (date == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(str).format(date);
        } catch (Exception e) {
            try {
                return new SimpleDateFormat(TIME_FORMAT).format(date);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    public static Date getFormatDateTime(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (Exception e) {
            try {
                return new SimpleDateFormat(TIME_FORMAT).parse(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static String getWeek() {
        return new SimpleDateFormat("EEEE").format(new Date());
    }

    public static String getWeekOfDate() {
        Date date = new Date();
        String[] strArr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(7) - 1;
        return strArr[i >= 0 ? i : 0];
    }

    public static long getNextDay(long j, int i) {
        Set<Integer> set;
        switch (i) {
            case 1:
                set = NORMAL_DAY;
                break;
            case 2:
                set = WORK_DAY;
                break;
            case 3:
                set = WEEKEND_DAY;
                break;
            default:
                set = NORMAL_DAY;
                break;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j + 86400000);
        while (!set.contains(Integer.valueOf(calendar.get(7)))) {
            calendar.setTimeInMillis(calendar.getTimeInMillis() + 86400000);
        }
        return calendar.getTimeInMillis();
    }

    public static boolean isSameDay(Long l, Long l2) {
        return l.longValue() / 86400000 == l2.longValue() / 86400000;
    }

    public static boolean isYesterday(Date date) {
        if (date == null) {
            return false;
        }
        return Long.valueOf(System.currentTimeMillis() / 86400000).longValue() - Long.valueOf(date.getTime() / 86400000).longValue() == 1;
    }

    public static boolean isFewDaysAgo(Long l, int i) {
        return Long.valueOf(System.currentTimeMillis() / 86400000).longValue() - Long.valueOf(l.longValue() / 86400000).longValue() >= ((long) i);
    }

    public static boolean isToday(Date date) {
        if (date == null) {
            return false;
        }
        Date date2 = new Date();
        return date2.getYear() == date.getYear() && date2.getMonth() == date.getMonth() && date2.getDate() == date.getDate();
    }

    public static String convertSecondToHumanView(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
            return "00:00";
        }
        long parseLong = Long.parseLong(str);
        return String.format("%02d:%02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60));
    }

    public static long interval(Long l, Long l2) {
        return Math.abs((l2.longValue() - l.longValue()) / 86400000);
    }

    public static void setDeltaTime(String str) {
        if (str != null) {
            try {
                mDelta = Long.parseLong(str) - (System.currentTimeMillis() / SECONDUNIT);
            } catch (Exception e) {
                e.printStackTrace();
                mDelta = 0L;
            }
        }
    }

    public static long getDelta() {
        return mDelta;
    }

    public static String getCalibratedTime() {
        return String.valueOf((System.currentTimeMillis() / SECONDUNIT) + mDelta);
    }

    public static String getFormatTeletextTime(Context context, long j) {
        return getFormatTeletextTime(context, j, true);
    }

    public static String getFormatTeletextTime(Context context, long j, boolean z) {
        String format;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - j;
            if (j2 < 0) {
                j = currentTimeMillis;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            boolean z2 = calendar.get(1) == Calendar.getInstance().get(1);
            long j3 = (j2 % MSEC_OF_ONE_DAY) / MSEC_OF_ONE_HOUR;
            long j4 = ((j2 % MSEC_OF_ONE_DAY) % MSEC_OF_ONE_HOUR) / MSEC_OF_ONE_MINUTE;
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(11, 0);
            calendar2.set(12, 0);
            calendar2.set(13, 0);
            calendar2.set(14, 0);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.add(5, -1);
            calendar3.set(11, 0);
            calendar3.set(12, 0);
            calendar3.set(13, 0);
            calendar3.set(14, 0);
            Calendar calendar4 = Calendar.getInstance();
            calendar4.add(5, -2);
            calendar4.set(11, 0);
            calendar4.set(12, 0);
            calendar4.set(13, 0);
            calendar4.set(14, 0);
            Calendar calendar5 = Calendar.getInstance();
            calendar5.add(2, -1);
            calendar5.set(11, 0);
            calendar5.set(12, 0);
            calendar5.set(13, 0);
            calendar5.set(14, 0);
            if (calendar.after(calendar2)) {
                if (j3 > 0) {
                    format = String.format(context.getString(R.string.time_liveshow_teletext_time_hour_before), Long.valueOf(j3));
                } else if (j4 > 0) {
                    format = String.format(context.getString(R.string.time_liveshow_teletext_time_min_before), Long.valueOf(j4));
                } else {
                    format = context.getString(R.string.time_liveshow_teletext_time_sec_before);
                }
            } else if (calendar.after(calendar5)) {
                format = String.format(context.getString(R.string.time_liveshow_teletext_time_day_before), Integer.valueOf((int) (((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / MSEC_OF_ONE_DAY) + 1)));
            } else if (z2) {
                format = new SimpleDateFormat(MD, Locale.getDefault()).format(calendar.getTime());
            } else {
                Date time = calendar.getTime();
                String str = "yyyy-MM-dd";
                if (z) {
                    str = Y4MD_HM;
                }
                format = new SimpleDateFormat(str, Locale.getDefault()).format(time);
            }
            return format;
        } catch (Exception e) {
            return String.valueOf(j);
        }
    }
}
