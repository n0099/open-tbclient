package com.baidu.swan.apps.t.a;
/* loaded from: classes19.dex */
public class b {
    private static volatile a cWe;

    public static synchronized a axm() {
        a aVar;
        synchronized (b.class) {
            if (cWe == null) {
                cWe = new a();
            }
            aVar = cWe;
        }
        return aVar;
    }
}
