package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ae {
    private static ae XH;
    private static volatile int XI = 0;
    private static int XJ = 300000;
    private static int XK = 10;
    public static int XL;

    private ae() {
        XL = TbadkCoreApplication.m10getInst().getNetWorkCoreType();
    }

    public static synchronized ae tG() {
        ae aeVar;
        synchronized (ae.class) {
            if (XH == null) {
                XH = new ae();
            }
            aeVar = XH;
        }
        return aeVar;
    }

    public t a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ac(aVar);
    }

    public static void cq(int i) {
        XL = i;
    }
}
