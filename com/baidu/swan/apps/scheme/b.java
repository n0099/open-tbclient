package com.baidu.swan.apps.scheme;
/* loaded from: classes6.dex */
public class b {
    private static volatile a dDR;

    public static synchronized a aJw() {
        a aVar;
        synchronized (b.class) {
            if (dDR == null) {
                dDR = new a();
            }
            aVar = dDR;
        }
        return aVar;
    }
}
