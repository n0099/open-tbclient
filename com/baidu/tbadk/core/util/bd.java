package com.baidu.tbadk.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class bd {
    public static Date vN() {
        return new Date(System.currentTimeMillis());
    }

    public static long vO() {
        return com.baidu.adp.lib.g.b.c(new SimpleDateFormat("yyyyMMdd").format(vN()), 0L);
    }
}
