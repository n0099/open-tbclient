package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac eSZ;
    public static int eTc;
    private static volatile int eTa = 0;
    private static int INTERVAL_TIME = 300000;
    private static int eTb = 10;

    private ac() {
        eTc = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ac btz() {
        ac acVar;
        synchronized (ac.class) {
            if (eSZ == null) {
                eSZ = new ac();
            }
            acVar = eSZ;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ab(aVar);
    }

    public static void pO(int i) {
        eTc = i;
    }
}
