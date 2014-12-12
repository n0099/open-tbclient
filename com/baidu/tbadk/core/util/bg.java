package com.baidu.tbadk.core.util;

import java.util.Date;
/* loaded from: classes.dex */
public class bg {
    public static boolean isSameDay(Date date, Date date2) {
        return date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay();
    }
}
