package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ab {
    private static ab ZO;
    private static volatile int ZP = 0;
    private static int ZQ = 300000;
    private static int ZR = 10;
    public static int ZS;

    private ab() {
        ZS = TbadkCoreApplication.m9getInst().getNetWorkCoreType();
    }

    public static synchronized ab uL() {
        ab abVar;
        synchronized (ab.class) {
            if (ZO == null) {
                ZO = new ab();
            }
            abVar = ZO;
        }
        return abVar;
    }

    public r a(com.baidu.tbadk.core.util.a.a aVar) {
        return new z(aVar);
    }

    public static void cF(int i) {
        ZS = i;
    }
}
