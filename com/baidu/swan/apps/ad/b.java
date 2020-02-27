package com.baidu.swan.apps.ad;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bGW;

    public static synchronized a Zr() {
        a aVar;
        synchronized (b.class) {
            if (bGW == null) {
                bGW = new a();
            }
            aVar = bGW;
        }
        return aVar;
    }
}
