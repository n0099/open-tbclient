package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac eLN;
    public static int eLQ;
    private static volatile int eLO = 0;
    private static int INTERVAL_TIME = 300000;
    private static int eLP = 10;

    private ac() {
        eLQ = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ac bqe() {
        ac acVar;
        synchronized (ac.class) {
            if (eLN == null) {
                eLN = new ac();
            }
            acVar = eLN;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ab(aVar);
    }

    public static void po(int i) {
        eLQ = i;
    }
}
