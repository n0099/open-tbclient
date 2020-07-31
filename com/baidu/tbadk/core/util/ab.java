package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ab {
    private static ab ear;
    public static int eau;
    private static volatile int eas = 0;
    private static int INTERVAL_TIME = 300000;
    private static int eat = 10;

    private ab() {
        eau = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized ab baz() {
        ab abVar;
        synchronized (ab.class) {
            if (ear == null) {
                ear = new ab();
            }
            abVar = ear;
        }
        return abVar;
    }

    public s a(com.baidu.tbadk.core.util.a.a aVar) {
        return new aa(aVar);
    }

    public static void lI(int i) {
        eau = i;
    }
}
