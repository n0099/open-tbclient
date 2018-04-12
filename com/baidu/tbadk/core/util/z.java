package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    public static int ahC;
    private static z ahy;
    private static volatile int ahz = 0;
    private static int ahA = 300000;
    private static int ahB = 10;

    private z() {
        ahC = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z vt() {
        z zVar;
        synchronized (z.class) {
            if (ahy == null) {
                ahy = new z();
            }
            zVar = ahy;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void cD(int i) {
        ahC = i;
    }
}
