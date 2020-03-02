package com.baidu.swan.apps.ad;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bGX;

    public static synchronized a Zt() {
        a aVar;
        synchronized (b.class) {
            if (bGX == null) {
                bGX = new a();
            }
            aVar = bGX;
        }
        return aVar;
    }
}
