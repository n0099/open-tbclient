package com.baidu.tbadk.core.util;

import java.util.Date;
/* loaded from: classes.dex */
public class bf {
    public static Date a() {
        return new Date(System.currentTimeMillis());
    }

    public static long a(Date date, Date date2) {
        return (date.getTime() - date2.getTime()) / 3600000;
    }

    public static boolean b(Date date, Date date2) {
        return date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay();
    }
}
