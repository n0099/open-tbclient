package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac ems;
    public static int emv;
    private static volatile int emt = 0;
    private static int INTERVAL_TIME = 300000;
    private static int emu = 10;

    private ac() {
        emv = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ac bjP() {
        ac acVar;
        synchronized (ac.class) {
            if (ems == null) {
                ems = new ac();
            }
            acVar = ems;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ab(aVar);
    }

    public static void oa(int i) {
        emv = i;
    }
}
