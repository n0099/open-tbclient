package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z aBd;
    private static volatile int aBe = 0;
    private static int aBf = 300000;
    private static int aBg = 10;
    public static int aBh;

    private z() {
        aBh = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z Dt() {
        z zVar;
        synchronized (z.class) {
            if (aBd == null) {
                aBd = new z();
            }
            zVar = aBd;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void dD(int i) {
        aBh = i;
    }
}
