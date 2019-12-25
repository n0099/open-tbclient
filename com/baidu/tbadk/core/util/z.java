package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z {
    private static z cVk;
    private static volatile int cVl = 0;
    private static int cVm = 300000;
    private static int cVn = 10;
    public static int cVo;

    private z() {
        cVo = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized z aDF() {
        z zVar;
        synchronized (z.class) {
            if (cVk == null) {
                cVk = new z();
            }
            zVar = cVk;
        }
        return zVar;
    }

    public q a(com.baidu.tbadk.core.util.a.a aVar) {
        return new y(aVar);
    }

    public static void ka(int i) {
        cVo = i;
    }
}
