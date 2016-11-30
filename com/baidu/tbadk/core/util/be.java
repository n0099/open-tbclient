package com.baidu.tbadk.core.util;

import java.util.Date;
/* loaded from: classes.dex */
public class be {
    public static long c(Date date, Date date2) {
        return (date.getTime() - date2.getTime()) / 86400000;
    }

    public static long d(Date date, Date date2) {
        return (date.getTime() - date2.getTime()) / 3600000;
    }
}
