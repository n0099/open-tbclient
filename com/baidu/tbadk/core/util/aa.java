package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class aa {
    private static aa aqe;
    private static volatile int aqf = 0;
    private static int aqg = 300000;
    private static int aqh = 10;
    public static int aqi;

    private aa() {
        aqi = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized aa zh() {
        aa aaVar;
        synchronized (aa.class) {
            if (aqe == null) {
                aqe = new aa();
            }
            aaVar = aqe;
        }
        return aaVar;
    }

    public r a(com.baidu.tbadk.core.util.a.a aVar) {
        return new z(aVar);
    }

    public static void cG(int i) {
        aqi = i;
    }
}
