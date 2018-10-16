package com.baidu.searchbox.ng.ai.apps.util;

import android.text.TextUtils;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class AiAppDateTimeUtil {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_CN = "yyyy年MM月dd日";
    public static final String DAY_FORMAT = "yyyyMMdd";
    public static final String DAY_FORMAT_MONTH_CN = "MM月dd日";
    public static final int MODE_NEXT_NORMAL_DAY = 1;
    public static final int MODE_NEXT_WEEKEND = 3;
    public static final int MODE_NEXT_WORKDAY = 2;
    public static final String MONTH_FORMAT = "yyyy-MM";
    public static final int TIME_DAY_MILLISECOND = 86400000;
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";
    public static final String YEAR_FORMAT = "yyyy";
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

    private AiAppDateTimeUtil() {
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
                return new SimpleDateFormat(DATE_FORMAT).format(date);
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
                return new SimpleDateFormat(DATE_FORMAT).parse(str);
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
}
