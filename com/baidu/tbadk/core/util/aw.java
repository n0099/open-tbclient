package com.baidu.tbadk.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class aw {
    public static Date wd() {
        return new Date(System.currentTimeMillis());
    }

    public static long we() {
        return com.baidu.adp.lib.g.b.c(new SimpleDateFormat("yyyyMMdd").format(wd()), 0L);
    }
}
