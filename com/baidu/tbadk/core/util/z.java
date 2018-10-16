package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z awQ;
    private static volatile int awR = 0;
    private static int awS = 300000;
    private static int awT = 10;
    public static int awU;

    private z() {
        awU = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z Ci() {
        z zVar;
        synchronized (z.class) {
            if (awQ == null) {
                awQ = new z();
            }
            zVar = awQ;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void db(int i) {
        awU = i;
    }
}
