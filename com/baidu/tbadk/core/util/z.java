package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z bJF;
    private static volatile int bJG = 0;
    private static int bJH = 300000;
    private static int bJI = 10;
    public static int bJJ;

    private z() {
        bJJ = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z acO() {
        z zVar;
        synchronized (z.class) {
            if (bJF == null) {
                bJF = new z();
            }
            zVar = bJF;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void he(int i) {
        bJJ = i;
    }
}
