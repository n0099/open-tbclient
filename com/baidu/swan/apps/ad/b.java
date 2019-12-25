package com.baidu.swan.apps.ad;
/* loaded from: classes4.dex */
public class b {
    private static volatile a bCe;

    public static synchronized a WG() {
        a aVar;
        synchronized (b.class) {
            if (bCe == null) {
                bCe = new a();
            }
            aVar = bCe;
        }
        return aVar;
    }
}
