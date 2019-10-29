package com.baidu.swan.apps.u.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aSE;

    public static synchronized a Ka() {
        a aVar;
        synchronized (b.class) {
            if (aSE == null) {
                aSE = new a();
            }
            aVar = aSE;
        }
        return aVar;
    }
}
