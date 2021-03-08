package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac fbG;
    public static int fbJ;
    private static volatile int fbH = 0;
    private static int INTERVAL_TIME = 300000;
    private static int fbI = 10;

    private ac() {
        fbJ = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ac bsy() {
        ac acVar;
        synchronized (ac.class) {
            if (fbG == null) {
                fbG = new ac();
            }
            acVar = fbG;
        }
        return acVar;
    }

    public t a(com.baidu.tbadk.core.util.b.a aVar) {
        return new ab(aVar);
    }

    public static void ox(int i) {
        fbJ = i;
    }
}
