package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aRL;

    public static synchronized a MM() {
        a aVar;
        synchronized (b.class) {
            if (aRL == null) {
                aRL = new a();
            }
            aVar = aRL;
        }
        return aVar;
    }
}
