package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z ciA;
    private static volatile int ciB = 0;
    private static int ciC = 300000;
    private static int ciD = 10;
    public static int ciE;

    private z() {
        ciE = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z amt() {
        z zVar;
        synchronized (z.class) {
            if (ciA == null) {
                ciA = new z();
            }
            zVar = ciA;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void io(int i) {
        ciE = i;
    }
}
