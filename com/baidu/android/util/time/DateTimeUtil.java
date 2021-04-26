package com.baidu.android.util.time;

import android.content.Context;
import com.baidu.android.app.event.EventBusWrapper;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
@Deprecated
/* loaded from: classes.dex */
public final class DateTimeUtil {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_CN = "yyyy年MM月dd日";
    public static final String DAY_FORMAT = "yyyyMMdd";
    public static final String DAY_FORMAT_MONTH_CN = "MM月dd日";
    public static final String MONTH_FORMAT = "yyyy-MM";
    public static final int TIME_DAY_MILLISECOND = 86400000;
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";
    public static final String YEAR_FORMAT = "yyyy";
    public static long mDelta;

    public static String convertSecondToHumanView(String str) {
        return DateTimeUtils.convertSecondToHumanView(str);
    }

    public static String getCalibratedTime() {
        return String.valueOf((System.currentTimeMillis() / 1000) + mDelta);
    }

    public static Date getCurrDate() {
        return new Date();
    }

    public static Timestamp getCurrTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static long getDelta() {
        return mDelta;
    }

    public static String getFormatDate(Date date, String str) {
        return DateTimeUtils.format(date, str);
    }

    public static String getFormatDateTime(Date date, String str) {
        return DateTimeUtils.getFormatDateTime(date, str);
    }

    public static String getFormatTeletextTime(Context context, long j) {
        return getFormatTeletextTime(context, j, true);
    }

    public static long getNextDay(long j, int i2) {
        return DateTimeUtils.getNextDayByMode(j, i2);
    }

    public static String getWeek() {
        return new SimpleDateFormat("EEEE").format(new Date());
    }

    public static String getWeekOfDate() {
        return DateTimeUtils.getWeekInZH();
    }

    public static long interval(Long l, Long l2) {
        return DateTimeUtils.interval(l.longValue(), l2.longValue());
    }

    public static boolean isFewDaysAgo(Long l, int i2) {
        return DateTimeUtils.isFewDaysAgo(l.longValue(), i2);
    }

    public static boolean isSameDay(Long l, Long l2) {
        return DateTimeUtils.isSameDay(l.longValue(), l2.longValue());
    }

    public static boolean isToday(Date date) {
        return DateTimeUtils.isToday(date);
    }

    public static boolean isYesterday(Date date) {
        return DateTimeUtils.isYesterday(date);
    }

    public static void setDeltaTime(String str) {
        if (str == null) {
            return;
        }
        try {
            long j = mDelta;
            long parseLong = Long.parseLong(str) - (System.currentTimeMillis() / 1000);
            mDelta = parseLong;
            if (j != parseLong) {
                EventBusWrapper.post(new ServerDeltaChangeEvent());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            mDelta = 0L;
        }
    }

    public static Date getFormatDate(String str, String str2) {
        return DateTimeUtils.format(str, str2);
    }

    public static Date getFormatDateTime(String str, String str2) {
        return DateTimeUtils.getFormatDateTime(str, str2);
    }

    public static String getFormatTeletextTime(Context context, long j, boolean z) {
        return DateTimeUtils.getFormatTeletextTime(context, j, z);
    }

    public static Date getFormatDate(String str, String[] strArr) {
        return DateTimeUtils.format(str, strArr);
    }
}
