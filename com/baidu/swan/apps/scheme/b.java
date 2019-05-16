package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aRb;

    public static synchronized a LY() {
        a aVar;
        synchronized (b.class) {
            if (aRb == null) {
                aRb = new a();
            }
            aVar = aRb;
        }
        return aVar;
    }
}
