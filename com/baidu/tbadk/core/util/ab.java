package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ab {
    private static ab fcB;
    public static int fcE;
    private static volatile int fcC = 0;
    private static int INTERVAL_TIME = 300000;
    private static int fcD = 10;

    private ab() {
        fcE = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ab bvV() {
        ab abVar;
        synchronized (ab.class) {
            if (fcB == null) {
                fcB = new ab();
            }
            abVar = fcB;
        }
        return abVar;
    }

    public s a(com.baidu.tbadk.core.util.b.a aVar) {
        return new aa(aVar);
    }

    public static void pY(int i) {
        fcE = i;
    }
}
