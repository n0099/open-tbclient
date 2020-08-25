package com.baidu.swan.apps.scheme;
/* loaded from: classes14.dex */
public class b {
    private static volatile a cRX;

    public static synchronized a aAN() {
        a aVar;
        synchronized (b.class) {
            if (cRX == null) {
                cRX = new a();
            }
            aVar = cRX;
        }
        return aVar;
    }
}
