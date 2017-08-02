package com.baidu.tbadk.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class as {
    public static Date vT() {
        return new Date(System.currentTimeMillis());
    }

    public static long vU() {
        return com.baidu.adp.lib.g.b.c(new SimpleDateFormat("yyyyMMdd").format(vT()), 0L);
    }
}
