package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class aa {
    private static aa apG;
    private static volatile int apH = 0;
    private static int apI = 300000;
    private static int apJ = 10;
    public static int apK;

    private aa() {
        apK = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized aa yW() {
        aa aaVar;
        synchronized (aa.class) {
            if (apG == null) {
                apG = new aa();
            }
            aaVar = apG;
        }
        return aaVar;
    }

    public r a(com.baidu.tbadk.core.util.a.a aVar) {
        return new z(aVar);
    }

    public static void cI(int i) {
        apK = i;
    }
}
