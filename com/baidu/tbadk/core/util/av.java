package com.baidu.tbadk.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class av {
    public static Date Dr() {
        return new Date(System.currentTimeMillis());
    }

    public static long Ds() {
        return com.baidu.adp.lib.g.b.c(new SimpleDateFormat("yyyyMMdd").format(Dr()), 0L);
    }
}
