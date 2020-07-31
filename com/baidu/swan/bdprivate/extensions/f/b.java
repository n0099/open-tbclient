package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes14.dex */
public class b {
    private static volatile a cXI;

    public static synchronized a ayJ() {
        a aVar;
        synchronized (b.class) {
            if (cXI == null) {
                cXI = new a();
            }
            aVar = cXI;
        }
        return aVar;
    }
}
