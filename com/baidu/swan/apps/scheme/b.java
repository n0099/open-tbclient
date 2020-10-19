package com.baidu.swan.apps.scheme;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dgj;

    public static synchronized a aEf() {
        a aVar;
        synchronized (b.class) {
            if (dgj == null) {
                dgj = new a();
            }
            aVar = dgj;
        }
        return aVar;
    }
}
