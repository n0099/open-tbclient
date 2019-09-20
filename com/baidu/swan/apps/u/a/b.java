package com.baidu.swan.apps.u.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a azp;

    public static synchronized a Fg() {
        a aVar;
        synchronized (b.class) {
            if (azp == null) {
                azp = new a();
            }
            aVar = azp;
        }
        return aVar;
    }
}
