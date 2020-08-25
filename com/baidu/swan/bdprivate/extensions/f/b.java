package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes14.dex */
public class b {
    private static volatile a dgR;

    public static synchronized a aGS() {
        a aVar;
        synchronized (b.class) {
            if (dgR == null) {
                dgR = new a();
            }
            aVar = dgR;
        }
        return aVar;
    }
}
