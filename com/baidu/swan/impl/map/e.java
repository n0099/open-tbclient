package com.baidu.swan.impl.map;
/* loaded from: classes5.dex */
public class e {
    private static volatile d cro;

    public static synchronized d apn() {
        d dVar;
        synchronized (e.class) {
            if (cro == null) {
                cro = new d();
            }
            dVar = cro;
        }
        return dVar;
    }
}
