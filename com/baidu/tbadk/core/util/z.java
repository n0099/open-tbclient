package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z ase;
    private static volatile int asf = 0;
    private static int asg = 300000;
    private static int ash = 10;
    public static int asi;

    private z() {
        asi = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z Ab() {
        z zVar;
        synchronized (z.class) {
            if (ase == null) {
                ase = new z();
            }
            zVar = ase;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void cR(int i) {
        asi = i;
    }
}
