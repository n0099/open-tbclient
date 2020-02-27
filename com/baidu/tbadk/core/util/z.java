package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    public static int cZA;
    private static z cZw;
    private static volatile int cZx = 0;
    private static int cZy = 300000;
    private static int cZz = 10;

    private z() {
        cZA = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z aGi() {
        z zVar;
        synchronized (z.class) {
            if (cZw == null) {
                cZw = new z();
            }
            zVar = cZw;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void kr(int i) {
        cZA = i;
    }
}
