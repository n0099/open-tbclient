package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class ac {
    private static ac ejZ;
    public static int ekc;
    private static volatile int eka = 0;
    private static int INTERVAL_TIME = 300000;
    private static int ekb = 10;

    private ac() {
        ekc = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ac biU() {
        ac acVar;
        synchronized (ac.class) {
            if (ejZ == null) {
                ejZ = new ac();
            }
            acVar = ejZ;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ab(aVar);
    }

    public static void nO(int i) {
        ekc = i;
    }
}
