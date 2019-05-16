package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z bRp;
    private static volatile int bRq = 0;
    private static int bRr = 300000;
    private static int bRs = 10;
    public static int bRt;

    private z() {
        bRt = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z ahM() {
        z zVar;
        synchronized (z.class) {
            if (bRp == null) {
                bRp = new z();
            }
            zVar = bRp;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void hS(int i) {
        bRt = i;
    }
}
