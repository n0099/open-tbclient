package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z agb;
    private static volatile int agc = 0;
    private static int agd = 300000;
    private static int agf = 10;
    public static int agg;

    private z() {
        agg = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z uX() {
        z zVar;
        synchronized (z.class) {
            if (agb == null) {
                agb = new z();
            }
            zVar = agb;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void cG(int i) {
        agg = i;
    }
}
