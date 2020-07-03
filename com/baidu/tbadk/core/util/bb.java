package com.baidu.tbadk.core.util;

import java.util.Date;
/* loaded from: classes.dex */
public class bb {
    public static boolean u(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis > j && currentTimeMillis < j2;
    }

    public static boolean b(Date date, Date date2) {
        return date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay();
    }
}
