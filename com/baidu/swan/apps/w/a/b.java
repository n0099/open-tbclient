package com.baidu.swan.apps.w.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a byh;

    public static synchronized a Vf() {
        a aVar;
        synchronized (b.class) {
            if (byh == null) {
                byh = new a();
            }
            aVar = byh;
        }
        return aVar;
    }
}
