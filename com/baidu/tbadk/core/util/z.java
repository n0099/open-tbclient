package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z dzd;
    private static volatile int dze = 0;
    private static int dzf = 300000;
    private static int dzg = 10;
    public static int dzh;

    private z() {
        dzh = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z aOA() {
        z zVar;
        synchronized (z.class) {
            if (dzd == null) {
                dzd = new z();
            }
            zVar = dzd;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void ky(int i) {
        dzh = i;
    }
}
