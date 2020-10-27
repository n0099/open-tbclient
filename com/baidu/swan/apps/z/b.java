package com.baidu.swan.apps.z;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dck;

    public static synchronized a aAD() {
        a aVar;
        synchronized (b.class) {
            if (dck == null) {
                dck = new a();
            }
            aVar = dck;
        }
        return aVar;
    }
}
