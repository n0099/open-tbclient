package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac aft;
    private static volatile int afu = 0;
    private static int afv = 300000;
    private static int afw = 10;
    public static int afx;

    private ac() {
        afx = TbadkCoreApplication.m9getInst().getNetWorkCoreType();
    }

    public static synchronized ac vF() {
        ac acVar;
        synchronized (ac.class) {
            if (aft == null) {
                aft = new ac();
            }
            acVar = aft;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new aa(aVar);
    }

    public static void cE(int i) {
        afx = i;
    }
}
