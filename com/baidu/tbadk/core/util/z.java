package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z dNi;
    public static int dNl;
    private static volatile int dNj = 0;
    private static int INTERVAL_TIME = 300000;
    private static int dNk = 10;

    private z() {
        dNl = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z aUE() {
        z zVar;
        synchronized (z.class) {
            if (dNi == null) {
                dNi = new z();
            }
            zVar = dNi;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void la(int i) {
        dNl = i;
    }
}
