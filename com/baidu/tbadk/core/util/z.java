package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z bSq;
    private static volatile int bSr = 0;
    private static int bSs = 300000;
    private static int bSt = 10;
    public static int bSu;

    private z() {
        bSu = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z aiO() {
        z zVar;
        synchronized (z.class) {
            if (bSq == null) {
                bSq = new z();
            }
            zVar = bSq;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void hY(int i) {
        bSu = i;
    }
}
