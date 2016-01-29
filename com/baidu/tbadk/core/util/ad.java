package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ad {
    private static ad abW;
    private static volatile int abX = 0;
    private static int abY = 300000;
    private static int abZ = 10;
    public static int aca;

    private ad() {
        aca = TbadkCoreApplication.m411getInst().getNetWorkCoreType();
    }

    public static synchronized ad vK() {
        ad adVar;
        synchronized (ad.class) {
            if (abW == null) {
                abW = new ad();
            }
            adVar = abW;
        }
        return adVar;
    }

    public t a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ab(aVar);
    }

    public static void cE(int i) {
        aca = i;
    }
}
