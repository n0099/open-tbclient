package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z bRq;
    private static volatile int bRr = 0;
    private static int bRs = 300000;
    private static int bRt = 10;
    public static int bRu;

    private z() {
        bRu = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z ahM() {
        z zVar;
        synchronized (z.class) {
            if (bRq == null) {
                bRq = new z();
            }
            zVar = bRq;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void hS(int i) {
        bRu = i;
    }
}
