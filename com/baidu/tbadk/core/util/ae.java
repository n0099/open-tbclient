package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ae {
    private static ae abi;
    private static volatile int abj = 0;
    private static int abk = 300000;
    private static int abl = 10;
    public static int abm;

    private ae() {
        abm = TbadkCoreApplication.m411getInst().getNetWorkCoreType();
    }

    public static synchronized ae wd() {
        ae aeVar;
        synchronized (ae.class) {
            if (abi == null) {
                abi = new ae();
            }
            aeVar = abi;
        }
        return aeVar;
    }

    public t a(com.baidu.tbadk.core.util.a.a aVar) {
        return new ac(aVar);
    }

    public static void cH(int i) {
        abm = i;
    }
}
