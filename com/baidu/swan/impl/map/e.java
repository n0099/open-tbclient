package com.baidu.swan.impl.map;
/* loaded from: classes7.dex */
public class e {
    private static volatile d erd;

    public static synchronized d beb() {
        d dVar;
        synchronized (e.class) {
            if (erd == null) {
                erd = new d();
            }
            dVar = erd;
        }
        return dVar;
    }
}
