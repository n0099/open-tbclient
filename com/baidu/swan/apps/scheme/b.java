package com.baidu.swan.apps.scheme;
/* loaded from: classes19.dex */
public class b {
    private static volatile a cUb;

    public static synchronized a aBw() {
        a aVar;
        synchronized (b.class) {
            if (cUb == null) {
                cUb = new a();
            }
            aVar = cUb;
        }
        return aVar;
    }
}
