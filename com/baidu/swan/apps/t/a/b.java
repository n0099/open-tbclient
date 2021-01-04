package com.baidu.swan.apps.t.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a dhU;

    public static synchronized a aBL() {
        a aVar;
        synchronized (b.class) {
            if (dhU == null) {
                dhU = new a();
            }
            aVar = dhU;
        }
        return aVar;
    }
}
