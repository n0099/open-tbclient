package com.baidu.swan.apps.z;
/* loaded from: classes7.dex */
public class b {
    private static volatile a dpU;

    public static synchronized a aDB() {
        a aVar;
        synchronized (b.class) {
            if (dpU == null) {
                dpU = new a();
            }
            aVar = dpU;
        }
        return aVar;
    }
}
