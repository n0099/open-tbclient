package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac aaA;
    private static volatile int aaB = 0;
    private static int aaC = 300000;
    private static int aaD = 10;
    public static int aaE;

    private ac() {
        aaE = TbadkCoreApplication.m9getInst().getNetWorkCoreType();
    }

    public static synchronized ac uR() {
        ac acVar;
        synchronized (ac.class) {
            if (aaA == null) {
                aaA = new ac();
            }
            acVar = aaA;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new aa(aVar);
    }

    public static void cG(int i) {
        aaE = i;
    }
}
