package com.baidu.swan.apps.t.a;
/* loaded from: classes6.dex */
public class b {
    private static volatile a dgU;

    public static synchronized a ayt() {
        a aVar;
        synchronized (b.class) {
            if (dgU == null) {
                dgU = new a();
            }
            aVar = dgU;
        }
        return aVar;
    }
}
