package com.baidu.tbadk.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class at {
    public static Date wb() {
        return new Date(System.currentTimeMillis());
    }

    public static long wc() {
        return com.baidu.adp.lib.g.b.c(new SimpleDateFormat("yyyyMMdd").format(wb()), 0L);
    }
}
