package com.baidu.swan.apps.scheme;
/* loaded from: classes14.dex */
public class b {
    private static volatile a cIX;

    public static synchronized a asB() {
        a aVar;
        synchronized (b.class) {
            if (cIX == null) {
                cIX = new a();
            }
            aVar = cIX;
        }
        return aVar;
    }
}
