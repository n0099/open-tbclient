package com.baidu.swan.apps.t.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a cXO;

    public static synchronized a axU() {
        a aVar;
        synchronized (b.class) {
            if (cXO == null) {
                cXO = new a();
            }
            aVar = cXO;
        }
        return aVar;
    }
}
