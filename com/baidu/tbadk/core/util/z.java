package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z agv;
    private static volatile int agw = 0;
    private static int agx = 300000;
    private static int agy = 10;
    public static int agz;

    private z() {
        agz = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z vt() {
        z zVar;
        synchronized (z.class) {
            if (agv == null) {
                agv = new z();
            }
            zVar = agv;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void cJ(int i) {
        agz = i;
    }
}
