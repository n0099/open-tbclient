package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aOW;

    public static synchronized a JD() {
        a aVar;
        synchronized (b.class) {
            if (aOW == null) {
                aOW = new a();
            }
            aVar = aOW;
        }
        return aVar;
    }
}
