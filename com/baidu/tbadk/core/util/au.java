package com.baidu.tbadk.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class au {
    public static Date Dg() {
        return new Date(System.currentTimeMillis());
    }

    public static long Dh() {
        return com.baidu.adp.lib.g.b.c(new SimpleDateFormat("yyyyMMdd").format(Dg()), 0L);
    }
}
