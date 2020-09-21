package com.baidu.swan.apps.t.a;
/* loaded from: classes19.dex */
public class b {
    private static volatile a cxu;

    public static synchronized a aqO() {
        a aVar;
        synchronized (b.class) {
            if (cxu == null) {
                cxu = new a();
            }
            aVar = cxu;
        }
        return aVar;
    }
}
