package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class y {
    private static y aak;
    private static volatile int aal = 0;
    private static int aam = 300000;
    private static int aan = 10;
    public static int aao;

    private y() {
        aao = TbadkCoreApplication.m411getInst().getNetWorkCoreType();
    }

    public static synchronized y ur() {
        y yVar;
        synchronized (y.class) {
            if (aak == null) {
                aak = new y();
            }
            yVar = aak;
        }
        return yVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new w(aVar);
    }

    public static void ck(int i) {
        aao = i;
    }
}
