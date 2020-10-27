package com.baidu.swan.apps.scheme;
/* loaded from: classes20.dex */
public class b {
    private static volatile a doL;

    public static synchronized a aFZ() {
        a aVar;
        synchronized (b.class) {
            if (doL == null) {
                doL = new a();
            }
            aVar = doL;
        }
        return aVar;
    }
}
