package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes7.dex */
public class c {
    private static volatile b cfN;

    public static synchronized b ajA() {
        b bVar;
        synchronized (c.class) {
            if (cfN == null) {
                cfN = new b();
            }
            bVar = cfN;
        }
        return bVar;
    }
}
