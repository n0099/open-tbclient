package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    public static int bSA;
    private static z bSw;
    private static volatile int bSx = 0;
    private static int bSy = 300000;
    private static int bSz = 10;

    private z() {
        bSA = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z aiQ() {
        z zVar;
        synchronized (z.class) {
            if (bSw == null) {
                bSw = new z();
            }
            zVar = bSw;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void hY(int i) {
        bSA = i;
    }
}
