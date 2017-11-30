package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static volatile int agA = 0;
    private static int agB = 300000;
    private static int agC = 10;
    public static int agD;
    private static z agz;

    private z() {
        agD = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z va() {
        z zVar;
        synchronized (z.class) {
            if (agz == null) {
                agz = new z();
            }
            zVar = agz;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void cH(int i) {
        agD = i;
    }
}
