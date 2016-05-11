package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ae {
    private static ae WI;
    private static volatile int WJ = 0;
    private static int WK = 300000;
    private static int WL = 10;
    public static int WM;

    private ae() {
        WM = TbadkCoreApplication.m11getInst().getNetWorkCoreType();
    }

    public static synchronized ae tJ() {
        ae aeVar;
        synchronized (ae.class) {
            if (WI == null) {
                WI = new ae();
            }
            aeVar = WI;
        }
        return aeVar;
    }

    public t a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ac(aVar);
    }

    public static void cq(int i) {
        WM = i;
    }
}
