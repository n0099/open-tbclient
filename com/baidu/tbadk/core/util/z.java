package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z aak;
    private static volatile int aal = 0;
    private static int aam = 300000;
    private static int aan = 10;
    public static int aao;

    private z() {
        aao = TbadkCoreApplication.m411getInst().getNetWorkCoreType();
    }

    public static synchronized z up() {
        z zVar;
        synchronized (z.class) {
            if (aak == null) {
                aak = new z();
            }
            zVar = aak;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new x(aVar);
    }

    public static void cm(int i) {
        aao = i;
    }
}
