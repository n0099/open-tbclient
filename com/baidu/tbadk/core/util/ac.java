package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac fah;
    public static int fak;
    private static volatile int fai = 0;
    private static int INTERVAL_TIME = 300000;
    private static int faj = 10;

    private ac() {
        fak = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ac bsv() {
        ac acVar;
        synchronized (ac.class) {
            if (fah == null) {
                fah = new ac();
            }
            acVar = fah;
        }
        return acVar;
    }

    public t a(com.baidu.tbadk.core.util.b.a aVar) {
        return new ab(aVar);
    }

    public static void ow(int i) {
        fak = i;
    }
}
