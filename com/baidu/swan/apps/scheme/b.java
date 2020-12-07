package com.baidu.swan.apps.scheme;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dzY;

    public static synchronized a aKZ() {
        a aVar;
        synchronized (b.class) {
            if (dzY == null) {
                dzY = new a();
            }
            aVar = dzY;
        }
        return aVar;
    }
}
