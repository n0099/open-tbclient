package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z afS;
    private static volatile int afT = 0;
    private static int afU = 300000;
    private static int afV = 10;
    public static int afW;

    private z() {
        afW = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z uX() {
        z zVar;
        synchronized (z.class) {
            if (afS == null) {
                afS = new z();
            }
            zVar = afS;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void cH(int i) {
        afW = i;
    }
}
