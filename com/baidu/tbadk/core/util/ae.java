package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ae {
    private static ae aaI;
    private static volatile int aaJ = 0;
    private static int aaK = 300000;
    private static int aaL = 10;
    public static int aaM;

    private ae() {
        aaM = TbadkCoreApplication.m9getInst().getNetWorkCoreType();
    }

    public static synchronized ae vb() {
        ae aeVar;
        synchronized (ae.class) {
            if (aaI == null) {
                aaI = new ae();
            }
            aeVar = aaI;
        }
        return aeVar;
    }

    public t a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ac(aVar);
    }

    public static void cD(int i) {
        aaM = i;
    }
}
