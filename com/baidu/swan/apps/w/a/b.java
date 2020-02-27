package com.baidu.swan.apps.w.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bxU;

    public static synchronized a Va() {
        a aVar;
        synchronized (b.class) {
            if (bxU == null) {
                bxU = new a();
            }
            aVar = bxU;
        }
        return aVar;
    }
}
