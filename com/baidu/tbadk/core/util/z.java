package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z aUF;
    private static volatile int aUG = 0;
    private static int aUH = 300000;
    private static int aUI = 10;
    public static int aUJ;

    private z() {
        aUJ = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z Cp() {
        z zVar;
        synchronized (z.class) {
            if (aUF == null) {
                aUF = new z();
            }
            zVar = aUF;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void fE(int i) {
        aUJ = i;
    }
}
