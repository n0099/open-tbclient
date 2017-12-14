package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z agt;
    private static volatile int agu = 0;
    private static int agv = 300000;
    private static int agw = 10;
    public static int agx;

    private z() {
        agx = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z uX() {
        z zVar;
        synchronized (z.class) {
            if (agt == null) {
                agt = new z();
            }
            zVar = agt;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void cH(int i) {
        agx = i;
    }
}
