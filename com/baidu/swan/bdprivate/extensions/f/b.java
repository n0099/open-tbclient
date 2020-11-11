package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dJt;

    public static synchronized a aOF() {
        a aVar;
        synchronized (b.class) {
            if (dJt == null) {
                dJt = new a();
            }
            aVar = dJt;
        }
        return aVar;
    }
}
