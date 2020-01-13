package com.baidu.swan.apps.scheme;
/* loaded from: classes5.dex */
public class b {
    private static volatile a bMu;

    public static synchronized a abr() {
        a aVar;
        synchronized (b.class) {
            if (bMu == null) {
                bMu = new a();
            }
            aVar = bMu;
        }
        return aVar;
    }
}
