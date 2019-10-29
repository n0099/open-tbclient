package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z cjr;
    private static volatile int cjs = 0;
    private static int cjt = 300000;
    private static int cju = 10;
    public static int cjv;

    private z() {
        cjv = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z amv() {
        z zVar;
        synchronized (z.class) {
            if (cjr == null) {
                cjr = new z();
            }
            zVar = cjr;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void ip(int i) {
        cjv = i;
    }
}
