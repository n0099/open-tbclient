package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z afG;
    private static volatile int afH = 0;
    private static int afI = 300000;
    private static int afJ = 10;
    public static int afK;

    private z() {
        afK = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z uQ() {
        z zVar;
        synchronized (z.class) {
            if (afG == null) {
                afG = new z();
            }
            zVar = afG;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void cG(int i) {
        afK = i;
    }
}
