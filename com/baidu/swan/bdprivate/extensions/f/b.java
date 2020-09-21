package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes19.dex */
public class b {
    private static volatile a diY;

    public static synchronized a aHC() {
        a aVar;
        synchronized (b.class) {
            if (diY == null) {
                diY = new a();
            }
            aVar = diY;
        }
        return aVar;
    }
}
