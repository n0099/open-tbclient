package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac afs;
    private static volatile int aft = 0;
    private static int afu = 300000;
    private static int afv = 10;
    public static int afw;

    private ac() {
        afw = TbadkCoreApplication.m9getInst().getNetWorkCoreType();
    }

    public static synchronized ac vF() {
        ac acVar;
        synchronized (ac.class) {
            if (afs == null) {
                afs = new ac();
            }
            acVar = afs;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new aa(aVar);
    }

    public static void cE(int i) {
        afw = i;
    }
}
