package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes7.dex */
public class c {
    private static volatile b cfM;

    public static synchronized b ajA() {
        b bVar;
        synchronized (c.class) {
            if (cfM == null) {
                cfM = new b();
            }
            bVar = cfM;
        }
        return bVar;
    }
}
