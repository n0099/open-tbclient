package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z bJB;
    private static volatile int bJC = 0;
    private static int bJD = 300000;
    private static int bJE = 10;
    public static int bJF;

    private z() {
        bJF = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z acR() {
        z zVar;
        synchronized (z.class) {
            if (bJB == null) {
                bJB = new z();
            }
            zVar = bJB;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void hf(int i) {
        bJF = i;
    }
}
