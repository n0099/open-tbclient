package com.baidu.tbadk.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class as {
    public static Date wd() {
        return new Date(System.currentTimeMillis());
    }

    public static long we() {
        return com.baidu.adp.lib.g.b.d(new SimpleDateFormat("yyyyMMdd").format(wd()), 0L);
    }
}
