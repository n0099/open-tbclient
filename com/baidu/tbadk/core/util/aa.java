package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class aa {
    private static aa dTY;
    public static int dUb;
    private static volatile int dTZ = 0;
    private static int INTERVAL_TIME = 300000;
    private static int dUa = 10;

    private aa() {
        dUb = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized aa aWy() {
        aa aaVar;
        synchronized (aa.class) {
            if (dTY == null) {
                dTY = new aa();
            }
            aaVar = dTY;
        }
        return aaVar;
    }

    public r a(com.baidu.tbadk.core.util.a.a aVar) {
        return new z(aVar);
    }

    public static void lo(int i) {
        dUb = i;
    }
}
