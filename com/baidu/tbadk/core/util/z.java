package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z cZL;
    private static volatile int cZM = 0;
    private static int cZN = 300000;
    private static int cZO = 10;
    public static int cZP;

    private z() {
        cZP = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z aGo() {
        z zVar;
        synchronized (z.class) {
            if (cZL == null) {
                cZL = new z();
            }
            zVar = cZL;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void kr(int i) {
        cZP = i;
    }
}
