package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class aa {
    private static aa apF;
    private static volatile int apG = 0;
    private static int apH = 300000;
    private static int apI = 10;
    public static int apJ;

    private aa() {
        apJ = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized aa yT() {
        aa aaVar;
        synchronized (aa.class) {
            if (apF == null) {
                apF = new aa();
            }
            aaVar = apF;
        }
        return aaVar;
    }

    public r a(com.baidu.tbadk.core.util.a.a aVar) {
        return new z(aVar);
    }

    public static void cF(int i) {
        apJ = i;
    }
}
