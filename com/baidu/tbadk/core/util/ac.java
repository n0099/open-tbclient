package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac eGZ;
    public static int eHc;
    private static volatile int eHa = 0;
    private static int INTERVAL_TIME = 300000;
    private static int eHb = 10;

    private ac() {
        eHc = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ac bor() {
        ac acVar;
        synchronized (ac.class) {
            if (eGZ == null) {
                eGZ = new ac();
            }
            acVar = eGZ;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ab(aVar);
    }

    public static void oI(int i) {
        eHc = i;
    }
}
