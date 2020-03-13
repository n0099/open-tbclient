package com.baidu.swan.apps.ad;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bGY;

    public static synchronized a Zt() {
        a aVar;
        synchronized (b.class) {
            if (bGY == null) {
                bGY = new a();
            }
            aVar = bGY;
        }
        return aVar;
    }
}
