package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class y {
    private static y aab;
    private static volatile int aac = 0;
    private static int aad = 300000;
    private static int aae = 10;
    public static int aaf;

    private y() {
        aaf = TbadkCoreApplication.m411getInst().getNetWorkCoreType();
    }

    public static synchronized y um() {
        y yVar;
        synchronized (y.class) {
            if (aab == null) {
                aab = new y();
            }
            yVar = aab;
        }
        return yVar;
    }

    public q a(com.baidu.tbadk.core.util.httpNet.a aVar) {
        return new w(aVar);
    }

    public static void cg(int i) {
        aaf = i;
    }
}
