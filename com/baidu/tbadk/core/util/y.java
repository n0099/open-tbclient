package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class y {
    private static y ahd;
    private static volatile int ahe = 0;
    private static int ahf = 300000;
    private static int ahg = 10;
    public static int ahh;

    private y() {
        ahh = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized y vv() {
        y yVar;
        synchronized (y.class) {
            if (ahd == null) {
                ahd = new y();
            }
            yVar = ahd;
        }
        return yVar;
    }

    public p a(com.baidu.tbadk.core.util.a.a aVar) {
        return new x(aVar);
    }

    public static void cI(int i) {
        ahh = i;
    }
}
