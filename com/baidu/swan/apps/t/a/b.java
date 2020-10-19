package com.baidu.swan.apps.t.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a cJz;

    public static synchronized a atA() {
        a aVar;
        synchronized (b.class) {
            if (cJz == null) {
                cJz = new a();
            }
            aVar = cJz;
        }
        return aVar;
    }
}
