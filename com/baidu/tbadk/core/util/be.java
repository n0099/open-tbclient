package com.baidu.tbadk.core.util;

import java.util.Date;
/* loaded from: classes.dex */
public class be {
    public static Date mQ() {
        return new Date(System.currentTimeMillis());
    }

    public static long c(Date date, Date date2) {
        return (date.getTime() - date2.getTime()) / 3600000;
    }

    public static boolean d(Date date, Date date2) {
        return date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay();
    }
}
