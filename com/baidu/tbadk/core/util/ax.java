package com.baidu.tbadk.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class ax {
    public static Date zE() {
        return new Date(System.currentTimeMillis());
    }

    public static long zF() {
        return com.baidu.adp.lib.g.b.c(new SimpleDateFormat("yyyyMMdd").format(zE()), 0L);
    }
}
