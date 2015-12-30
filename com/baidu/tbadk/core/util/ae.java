package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ae {
    private static ae abA;
    private static volatile int abB = 0;
    private static int abC = 300000;
    private static int abD = 10;
    public static int abE;

    private ae() {
        abE = TbadkCoreApplication.m411getInst().getNetWorkCoreType();
    }

    public static synchronized ae uF() {
        ae aeVar;
        synchronized (ae.class) {
            if (abA == null) {
                abA = new ae();
            }
            aeVar = abA;
        }
        return aeVar;
    }

    public u a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ac(aVar);
    }

    public static void cn(int i) {
        abE = i;
    }
}
