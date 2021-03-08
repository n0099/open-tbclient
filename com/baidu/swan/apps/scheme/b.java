package com.baidu.swan.apps.scheme;
/* loaded from: classes6.dex */
public class b {
    private static volatile a dHw;

    public static synchronized a aJS() {
        a aVar;
        synchronized (b.class) {
            if (dHw == null) {
                dHw = new a();
            }
            aVar = dHw;
        }
        return aVar;
    }
}
