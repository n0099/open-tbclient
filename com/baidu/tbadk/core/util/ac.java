package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac aeC;
    private static volatile int aeD = 0;
    private static int aeE = 300000;
    private static int aeF = 10;
    public static int aeG;

    private ac() {
        aeG = TbadkCoreApplication.m9getInst().getNetWorkCoreType();
    }

    public static synchronized ac uP() {
        ac acVar;
        synchronized (ac.class) {
            if (aeC == null) {
                aeC = new ac();
            }
            acVar = aeC;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new aa(aVar);
    }

    public static void cC(int i) {
        aeG = i;
    }
}
