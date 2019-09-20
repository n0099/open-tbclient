package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z bSX;
    private static volatile int bSY = 0;
    private static int bSZ = 300000;
    private static int bTa = 10;
    public static int bTb;

    private z() {
        bTb = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z aiU() {
        z zVar;
        synchronized (z.class) {
            if (bSX == null) {
                bSX = new z();
            }
            zVar = bSX;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void hY(int i) {
        bTb = i;
    }
}
