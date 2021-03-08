package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes6.dex */
public class b {
    private static volatile a dWx;

    public static synchronized a aQa() {
        a aVar;
        synchronized (b.class) {
            if (dWx == null) {
                dWx = new a();
            }
            aVar = dWx;
        }
        return aVar;
    }
}
