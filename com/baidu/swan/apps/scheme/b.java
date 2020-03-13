package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bQB;

    public static synchronized a adH() {
        a aVar;
        synchronized (b.class) {
            if (bQB == null) {
                bQB = new a();
            }
            aVar = bQB;
        }
        return aVar;
    }
}
