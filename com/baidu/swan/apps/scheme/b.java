package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aSj;

    public static synchronized a MQ() {
        a aVar;
        synchronized (b.class) {
            if (aSj == null) {
                aSj = new a();
            }
            aVar = aSj;
        }
        return aVar;
    }
}
