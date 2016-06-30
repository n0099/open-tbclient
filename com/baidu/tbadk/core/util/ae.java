package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ae {
    private static ae WY;
    private static volatile int WZ = 0;
    private static int Xa = 300000;
    private static int Xb = 10;
    public static int Xc;

    private ae() {
        Xc = TbadkCoreApplication.m9getInst().getNetWorkCoreType();
    }

    public static synchronized ae tH() {
        ae aeVar;
        synchronized (ae.class) {
            if (WY == null) {
                WY = new ae();
            }
            aeVar = WY;
        }
        return aeVar;
    }

    public t a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ac(aVar);
    }

    public static void cq(int i) {
        Xc = i;
    }
}
