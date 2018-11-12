package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z axD;
    private static volatile int axE = 0;
    private static int axF = 300000;
    private static int axG = 10;
    public static int axH;

    private z() {
        axH = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z Cp() {
        z zVar;
        synchronized (z.class) {
            if (axD == null) {
                axD = new z();
            }
            zVar = axD;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void dp(int i) {
        axH = i;
    }
}
