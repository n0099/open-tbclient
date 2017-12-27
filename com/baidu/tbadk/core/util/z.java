package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z aUG;
    private static volatile int aUH = 0;
    private static int aUI = 300000;
    private static int aUJ = 10;
    public static int aUK;

    private z() {
        aUK = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z Cx() {
        z zVar;
        synchronized (z.class) {
            if (aUG == null) {
                aUG = new z();
            }
            zVar = aUG;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void fG(int i) {
        aUK = i;
    }
}
