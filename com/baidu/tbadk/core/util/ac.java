package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ac {
    private static ac afe;
    private static volatile int aff = 0;
    private static int afg = 300000;
    private static int afh = 10;
    public static int afi;

    private ac() {
        afi = TbadkCoreApplication.m9getInst().getNetWorkCoreType();
    }

    public static synchronized ac vi() {
        ac acVar;
        synchronized (ac.class) {
            if (afe == null) {
                afe = new ac();
            }
            acVar = afe;
        }
        return acVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new aa(aVar);
    }

    public static void cB(int i) {
        afi = i;
    }
}
