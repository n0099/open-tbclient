package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac aeL;
    private static volatile int aeM = 0;
    private static int aeN = 300000;
    private static int aeO = 10;
    public static int aeP;

    private ac() {
        aeP = TbadkCoreApplication.m9getInst().getNetWorkCoreType();
    }

    public static synchronized ac uS() {
        ac acVar;
        synchronized (ac.class) {
            if (aeL == null) {
                aeL = new ac();
            }
            acVar = aeL;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new aa(aVar);
    }

    public static void cB(int i) {
        aeP = i;
    }
}
