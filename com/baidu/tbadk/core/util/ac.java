package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac eMO;
    public static int eMR;
    private static volatile int eMP = 0;
    private static int INTERVAL_TIME = 300000;
    private static int eMQ = 10;

    private ac() {
        eMR = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ac bqR() {
        ac acVar;
        synchronized (ac.class) {
            if (eMO == null) {
                eMO = new ac();
            }
            acVar = eMO;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ab(aVar);
    }

    public static void oS(int i) {
        eMR = i;
    }
}
