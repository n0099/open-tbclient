package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac eyD;
    public static int eyG;
    private static volatile int eyE = 0;
    private static int INTERVAL_TIME = 300000;
    private static int eyF = 10;

    private ac() {
        eyG = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ac bmy() {
        ac acVar;
        synchronized (ac.class) {
            if (eyD == null) {
                eyD = new ac();
            }
            acVar = eyD;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ab(aVar);
    }

    public static void ox(int i) {
        eyG = i;
    }
}
