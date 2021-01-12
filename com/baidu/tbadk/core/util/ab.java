package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ab {
    private static ab eXS;
    public static int eXV;
    private static volatile int eXT = 0;
    private static int INTERVAL_TIME = 300000;
    private static int eXU = 10;

    private ab() {
        eXV = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ab bsb() {
        ab abVar;
        synchronized (ab.class) {
            if (eXS == null) {
                eXS = new ab();
            }
            abVar = eXS;
        }
        return abVar;
    }

    public s a(com.baidu.tbadk.core.util.b.a aVar) {
        return new aa(aVar);
    }

    public static void or(int i) {
        eXV = i;
    }
}
