package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z dyZ;
    private static volatile int dza = 0;
    private static int dzb = 300000;
    private static int dzc = 10;
    public static int dzd;

    private z() {
        dzd = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z aOC() {
        z zVar;
        synchronized (z.class) {
            if (dyZ == null) {
                dyZ = new z();
            }
            zVar = dyZ;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void ky(int i) {
        dzd = i;
    }
}
