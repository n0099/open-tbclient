package com.baidu.swan.apps.w.a;
/* loaded from: classes5.dex */
public class b {
    private static volatile a btK;

    public static synchronized a SM() {
        a aVar;
        synchronized (b.class) {
            if (btK == null) {
                btK = new a();
            }
            aVar = btK;
        }
        return aVar;
    }
}
