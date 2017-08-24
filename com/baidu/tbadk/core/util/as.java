package com.baidu.tbadk.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class as {
    public static Date we() {
        return new Date(System.currentTimeMillis());
    }

    public static long wf() {
        return com.baidu.adp.lib.g.b.d(new SimpleDateFormat("yyyyMMdd").format(we()), 0L);
    }
}
