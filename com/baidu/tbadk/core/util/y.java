package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class y {
    private static y ahb;
    private static volatile int ahc = 0;
    private static int ahd = 300000;
    private static int ahe = 10;
    public static int ahf;

    private y() {
        ahf = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized y vv() {
        y yVar;
        synchronized (y.class) {
            if (ahb == null) {
                ahb = new y();
            }
            yVar = ahb;
        }
        return yVar;
    }

    public p a(com.baidu.tbadk.core.util.a.a aVar) {
        return new x(aVar);
    }

    public static void cI(int i) {
        ahf = i;
    }
}
