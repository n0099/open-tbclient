package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ae {
    private static ae Va;
    private static volatile int Vb = 0;
    private static int Vc = 300000;
    private static int Vd = 10;
    public static int Ve;

    private ae() {
        Ve = TbadkCoreApplication.m411getInst().getNetWorkCoreType();
    }

    public static synchronized ae tf() {
        ae aeVar;
        synchronized (ae.class) {
            if (Va == null) {
                Va = new ae();
            }
            aeVar = Va;
        }
        return aeVar;
    }

    public s a(com.baidu.tbadk.core.util.httpNet.a aVar) {
        return new ab(aVar);
    }

    public static void bY(int i) {
        Ve = i;
    }
}
