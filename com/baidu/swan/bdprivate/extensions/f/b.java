package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes6.dex */
public class b {
    private static volatile a dSQ;

    public static synchronized a aPE() {
        a aVar;
        synchronized (b.class) {
            if (dSQ == null) {
                dSQ = new a();
            }
            aVar = dSQ;
        }
        return aVar;
    }
}
