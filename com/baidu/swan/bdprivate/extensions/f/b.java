package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dve;

    public static synchronized a aKl() {
        a aVar;
        synchronized (b.class) {
            if (dve == null) {
                dve = new a();
            }
            aVar = dve;
        }
        return aVar;
    }
}
