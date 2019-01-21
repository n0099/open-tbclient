package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z aBG;
    private static volatile int aBH = 0;
    private static int aBI = 300000;
    private static int aBJ = 10;
    public static int aBK;

    private z() {
        aBK = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z DG() {
        z zVar;
        synchronized (z.class) {
            if (aBG == null) {
                aBG = new z();
            }
            zVar = aBG;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void dD(int i) {
        aBK = i;
    }
}
