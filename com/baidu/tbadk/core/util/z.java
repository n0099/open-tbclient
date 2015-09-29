package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z aae;
    private static volatile int aaf = 0;
    private static int aag = 300000;
    private static int aah = 10;
    public static int aai;

    private z() {
        aai = TbadkCoreApplication.m411getInst().getNetWorkCoreType();
    }

    public static synchronized z up() {
        z zVar;
        synchronized (z.class) {
            if (aae == null) {
                aae = new z();
            }
            zVar = aae;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new x(aVar);
    }

    public static void cm(int i) {
        aai = i;
    }
}
