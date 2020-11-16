package com.baidu.tbadk.core.util;

import java.util.Date;
/* loaded from: classes.dex */
public class be {
    public static boolean s(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis > j && currentTimeMillis < j2;
    }

    public static long b(Date date, Date date2) {
        return (date.getTime() - date2.getTime()) / 86400000;
    }

    public static boolean c(Date date, Date date2) {
        return date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay();
    }

    public static boolean dC(long j) {
        return new Date(j).getYear() == new Date(System.currentTimeMillis()).getYear();
    }
}
