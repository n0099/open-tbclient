package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes7.dex */
public class b {
    private static volatile a dXC;

    public static synchronized a aTy() {
        a aVar;
        synchronized (b.class) {
            if (dXC == null) {
                dXC = new a();
            }
            aVar = dXC;
        }
        return aVar;
    }
}
