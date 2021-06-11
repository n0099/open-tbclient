package com.baidu.tbadk.core.util;

import d.a.c.e.m.b;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class TimeHelper {
    public static long getDayDifference(Date date, Date date2) {
        return (date.getTime() - date2.getTime()) / 86400000;
    }

    public static long getFormatDateLong() {
        return b.f(new SimpleDateFormat("yyyyMMdd").format(getNow()), 0L);
    }

    public static long getHourDifference(Date date, Date date2) {
        return (date.getTime() - date2.getTime()) / 3600000;
    }

    public static long getMinuteDifference(Date date, Date date2) {
        long time = date.getTime() - date2.getTime();
        long j = (time / 86400000) * 24;
        return ((time / 60000) - (j * 60)) - (((time / 3600000) - j) * 60);
    }

    public static Date getNow() {
        return new Date(System.currentTimeMillis());
    }

    public static long getSecondDifference(Date date, Date date2) {
        long time = date.getTime() - date2.getTime();
        long j = (time / 86400000) * 24;
        long j2 = (time / 3600000) - j;
        long j3 = j * 60;
        long j4 = j2 * 60;
        return (((time / 1000) - (j3 * 60)) - (j4 * 60)) - ((((time / 60000) - j3) - j4) * 60);
    }

    public static boolean isInTimeBlock(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis > j && currentTimeMillis < j2;
    }

    public static boolean isSameDay(Date date, Date date2) {
        return date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay();
    }

    public static boolean isSameYear(long j) {
        return new Date(j).getYear() == new Date(System.currentTimeMillis()).getYear();
    }
}
