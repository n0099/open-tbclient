package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac abg;
    private static volatile int abh = 0;
    private static int abi = 300000;
    private static int abj = 10;
    public static int abk;

    private ac() {
        abk = TbadkCoreApplication.m9getInst().getNetWorkCoreType();
    }

    public static synchronized ac vf() {
        ac acVar;
        synchronized (ac.class) {
            if (abg == null) {
                abg = new ac();
            }
            acVar = abg;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new aa(aVar);
    }

    public static void cE(int i) {
        abk = i;
    }
}
