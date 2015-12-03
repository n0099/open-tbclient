package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ae {
    private static ae aaW;
    private static volatile int aaX = 0;
    private static int aaY = 300000;
    private static int aaZ = 10;
    public static int aba;

    private ae() {
        aba = TbadkCoreApplication.m411getInst().getNetWorkCoreType();
    }

    public static synchronized ae uV() {
        ae aeVar;
        synchronized (ae.class) {
            if (aaW == null) {
                aaW = new ae();
            }
            aeVar = aaW;
        }
        return aeVar;
    }

    public u a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ac(aVar);
    }

    public static void cu(int i) {
        aba = i;
    }
}
