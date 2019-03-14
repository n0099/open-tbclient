package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aOT;

    public static synchronized a JF() {
        a aVar;
        synchronized (b.class) {
            if (aOT == null) {
                aOT = new a();
            }
            aVar = aOT;
        }
        return aVar;
    }
}
