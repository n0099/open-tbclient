package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes14.dex */
public class b {
    private static volatile a dgV;

    public static synchronized a aGS() {
        a aVar;
        synchronized (b.class) {
            if (dgV == null) {
                dgV = new a();
            }
            aVar = dgV;
        }
        return aVar;
    }
}
