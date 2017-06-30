package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ae {
    private static ae afk;
    private static volatile int afl = 0;
    private static int afm = 300000;
    private static int afn = 10;
    public static int afo;

    private ae() {
        afo = TbadkCoreApplication.m9getInst().getNetWorkCoreType();
    }

    public static synchronized ae vf() {
        ae aeVar;
        synchronized (ae.class) {
            if (afk == null) {
                afk = new ae();
            }
            aeVar = afk;
        }
        return aeVar;
    }

    public u a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ac(aVar);
    }

    public static void cE(int i) {
        afo = i;
    }
}
