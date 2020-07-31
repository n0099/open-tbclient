package com.baidu.tbadk.core.util;

import java.util.Date;
/* loaded from: classes.dex */
public class bc {
    public static boolean v(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis > j && currentTimeMillis < j2;
    }

    public static boolean cK(long j) {
        return new Date(j).getYear() == new Date(System.currentTimeMillis()).getYear();
    }
}
