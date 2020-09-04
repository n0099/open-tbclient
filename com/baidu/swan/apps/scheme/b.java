package com.baidu.swan.apps.scheme;
/* loaded from: classes14.dex */
public class b {
    private static volatile a cSb;

    public static synchronized a aAN() {
        a aVar;
        synchronized (b.class) {
            if (cSb == null) {
                cSb = new a();
            }
            aVar = cSb;
        }
        return aVar;
    }
}
