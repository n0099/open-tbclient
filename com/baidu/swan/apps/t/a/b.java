package com.baidu.swan.apps.t.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a ddb;

    public static synchronized a aAu() {
        a aVar;
        synchronized (b.class) {
            if (ddb == null) {
                ddb = new a();
            }
            aVar = ddb;
        }
        return aVar;
    }
}
