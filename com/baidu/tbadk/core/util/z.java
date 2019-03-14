package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z bJC;
    private static volatile int bJD = 0;
    private static int bJE = 300000;
    private static int bJF = 10;
    public static int bJG;

    private z() {
        bJG = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z acR() {
        z zVar;
        synchronized (z.class) {
            if (bJC == null) {
                bJC = new z();
            }
            zVar = bJC;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void hf(int i) {
        bJG = i;
    }
}
