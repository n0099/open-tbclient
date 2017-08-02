package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class y {
    private static y afG;
    private static volatile int afH = 0;
    private static int afI = 300000;
    private static int afJ = 10;
    public static int afK;

    private y() {
        afK = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized y vl() {
        y yVar;
        synchronized (y.class) {
            if (afG == null) {
                afG = new y();
            }
            yVar = afG;
        }
        return yVar;
    }

    public p a(com.baidu.tbadk.core.util.a.a aVar) {
        return new x(aVar);
    }

    public static void cG(int i) {
        afK = i;
    }
}
