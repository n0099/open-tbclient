package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z aUI;
    private static volatile int aUJ = 0;
    private static int aUK = 300000;
    private static int aUL = 10;
    public static int aUM;

    private z() {
        aUM = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z Cq() {
        z zVar;
        synchronized (z.class) {
            if (aUI == null) {
                aUI = new z();
            }
            zVar = aUI;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void fE(int i) {
        aUM = i;
    }
}
