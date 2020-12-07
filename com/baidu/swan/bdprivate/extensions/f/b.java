package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dOJ;

    public static synchronized a aRc() {
        a aVar;
        synchronized (b.class) {
            if (dOJ == null) {
                dOJ = new a();
            }
            aVar = dOJ;
        }
        return aVar;
    }
}
