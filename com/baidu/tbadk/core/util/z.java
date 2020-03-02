package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    public static int cZB;
    private static z cZx;
    private static volatile int cZy = 0;
    private static int cZz = 300000;
    private static int cZA = 10;

    private z() {
        cZB = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z aGk() {
        z zVar;
        synchronized (z.class) {
            if (cZx == null) {
                cZx = new z();
            }
            zVar = cZx;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void kr(int i) {
        cZB = i;
    }
}
