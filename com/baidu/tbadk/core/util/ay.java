package com.baidu.tbadk.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class ay {
    public static Date zT() {
        return new Date(System.currentTimeMillis());
    }

    public static long zU() {
        return com.baidu.adp.lib.g.b.c(new SimpleDateFormat("yyyyMMdd").format(zT()), 0L);
    }
}
