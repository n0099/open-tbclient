package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z aag;
    private static volatile int aah = 0;
    private static int aai = 300000;
    private static int aaj = 10;
    public static int aak;

    private z() {
        aak = TbadkCoreApplication.m411getInst().getNetWorkCoreType();
    }

    public static synchronized z um() {
        z zVar;
        synchronized (z.class) {
            if (aag == null) {
                aag = new z();
            }
            zVar = aag;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new x(aVar);
    }

    public static void cm(int i) {
        aak = i;
    }
}
