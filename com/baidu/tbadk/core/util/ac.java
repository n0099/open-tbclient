package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac ekd;
    public static int ekg;
    private static volatile int eke = 0;
    private static int INTERVAL_TIME = 300000;
    private static int ekf = 10;

    private ac() {
        ekg = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ac biU() {
        ac acVar;
        synchronized (ac.class) {
            if (ekd == null) {
                ekd = new ac();
            }
            acVar = ekd;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ab(aVar);
    }

    public static void nO(int i) {
        ekg = i;
    }
}
