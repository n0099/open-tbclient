package com.baidu.swan.apps.scheme;
/* loaded from: classes19.dex */
public class b {
    private static volatile a dsY;

    public static synchronized a aHR() {
        a aVar;
        synchronized (b.class) {
            if (dsY == null) {
                dsY = new a();
            }
            aVar = dsY;
        }
        return aVar;
    }
}
