package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cGf;

    public static synchronized a aqS() {
        a aVar;
        synchronized (b.class) {
            if (cGf == null) {
                cGf = new a();
            }
            aVar = cGf;
        }
        return aVar;
    }
}
