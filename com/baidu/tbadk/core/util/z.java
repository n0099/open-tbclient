package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z aBF;
    private static volatile int aBG = 0;
    private static int aBH = 300000;
    private static int aBI = 10;
    public static int aBJ;

    private z() {
        aBJ = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z DG() {
        z zVar;
        synchronized (z.class) {
            if (aBF == null) {
                aBF = new z();
            }
            zVar = aBF;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void dD(int i) {
        aBJ = i;
    }
}
