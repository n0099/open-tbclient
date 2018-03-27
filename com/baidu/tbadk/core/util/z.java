package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z aWe;
    private static volatile int aWf = 0;
    private static int aWg = 300000;
    private static int aWh = 10;
    public static int aWi;

    private z() {
        aWi = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z CJ() {
        z zVar;
        synchronized (z.class) {
            if (aWe == null) {
                aWe = new z();
            }
            zVar = aWe;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void fE(int i) {
        aWi = i;
    }
}
