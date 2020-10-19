package com.baidu.swan.bdprivate.d;
/* loaded from: classes20.dex */
public class c {
    private static volatile b dvx;

    public static synchronized b aKp() {
        b bVar;
        synchronized (c.class) {
            if (dvx == null) {
                dvx = new b();
            }
            bVar = dvx;
        }
        return bVar;
    }
}
