package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    public static int agA;
    private static z agw;
    private static volatile int agx = 0;
    private static int agy = 300000;
    private static int agz = 10;

    private z() {
        agA = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z vt() {
        z zVar;
        synchronized (z.class) {
            if (agw == null) {
                agw = new z();
            }
            zVar = agw;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void cJ(int i) {
        agA = i;
    }
}
