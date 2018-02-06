package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z aWo;
    private static volatile int aWp = 0;
    private static int aWq = 300000;
    private static int aWr = 10;
    public static int aWs;

    private z() {
        aWs = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z CJ() {
        z zVar;
        synchronized (z.class) {
            if (aWo == null) {
                aWo = new z();
            }
            zVar = aWo;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void fE(int i) {
        aWs = i;
    }
}
