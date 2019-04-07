package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z bJE;
    private static volatile int bJF = 0;
    private static int bJG = 300000;
    private static int bJH = 10;
    public static int bJI;

    private z() {
        bJI = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z acO() {
        z zVar;
        synchronized (z.class) {
            if (bJE == null) {
                bJE = new z();
            }
            zVar = bJE;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void he(int i) {
        bJI = i;
    }
}
