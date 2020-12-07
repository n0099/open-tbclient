package com.baidu.swan.apps.z;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dny;

    public static synchronized a aFE() {
        a aVar;
        synchronized (b.class) {
            if (dny == null) {
                dny = new a();
            }
            aVar = dny;
        }
        return aVar;
    }
}
