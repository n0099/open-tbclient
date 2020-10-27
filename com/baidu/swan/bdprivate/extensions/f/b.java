package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dDB;

    public static synchronized a aMf() {
        a aVar;
        synchronized (b.class) {
            if (dDB == null) {
                dDB = new a();
            }
            aVar = dDB;
        }
        return aVar;
    }
}
