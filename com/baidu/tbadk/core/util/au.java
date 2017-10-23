package com.baidu.tbadk.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class au {
    public static Date vy() {
        return new Date(System.currentTimeMillis());
    }

    public static long vz() {
        return com.baidu.adp.lib.g.b.c(new SimpleDateFormat("yyyyMMdd").format(vy()), 0L);
    }
}
