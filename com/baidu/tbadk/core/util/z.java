package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z aWc;
    private static volatile int aWd = 0;
    private static int aWe = 300000;
    private static int aWf = 10;
    public static int aWg;

    private z() {
        aWg = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z CI() {
        z zVar;
        synchronized (z.class) {
            if (aWc == null) {
                aWc = new z();
            }
            zVar = aWc;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void fE(int i) {
        aWg = i;
    }
}
