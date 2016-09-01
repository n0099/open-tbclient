package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ae {
    private static ae aav;
    private static volatile int aaw = 0;
    private static int aax = 300000;
    private static int aay = 10;
    public static int aaz;

    private ae() {
        aaz = TbadkCoreApplication.m9getInst().getNetWorkCoreType();
    }

    public static synchronized ae uM() {
        ae aeVar;
        synchronized (ae.class) {
            if (aav == null) {
                aav = new ae();
            }
            aeVar = aav;
        }
        return aeVar;
    }

    public t a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ac(aVar);
    }

    public static void cD(int i) {
        aaz = i;
    }
}
