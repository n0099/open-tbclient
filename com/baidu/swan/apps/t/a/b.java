package com.baidu.swan.apps.t.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a cRV;

    public static synchronized a avu() {
        a aVar;
        synchronized (b.class) {
            if (cRV == null) {
                cRV = new a();
            }
            aVar = cRV;
        }
        return aVar;
    }
}
