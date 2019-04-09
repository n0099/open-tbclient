package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aOX;

    public static synchronized a JD() {
        a aVar;
        synchronized (b.class) {
            if (aOX == null) {
                aOX = new a();
            }
            aVar = aOX;
        }
        return aVar;
    }
}
