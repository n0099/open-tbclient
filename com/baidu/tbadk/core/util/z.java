package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    public static int cZC;
    private static z cZy;
    private static volatile int cZz = 0;
    private static int cZA = 300000;
    private static int cZB = 10;

    private z() {
        cZC = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z aGk() {
        z zVar;
        synchronized (z.class) {
            if (cZy == null) {
                cZy = new z();
            }
            zVar = cZy;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void kr(int i) {
        cZC = i;
    }
}
