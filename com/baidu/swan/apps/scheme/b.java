package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class b {
    private static volatile a dFV;

    public static synchronized a aJP() {
        a aVar;
        synchronized (b.class) {
            if (dFV == null) {
                dFV = new a();
            }
            aVar = dFV;
        }
        return aVar;
    }
}
