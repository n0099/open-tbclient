package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z cVu;
    private static volatile int cVv = 0;
    private static int cVw = 300000;
    private static int cVx = 10;
    public static int cVy;

    private z() {
        cVy = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z aDY() {
        z zVar;
        synchronized (z.class) {
            if (cVu == null) {
                cVu = new z();
            }
            zVar = cVu;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void ka(int i) {
        cVy = i;
    }
}
