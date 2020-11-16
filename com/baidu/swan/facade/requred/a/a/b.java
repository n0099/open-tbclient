package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes19.dex */
public class b {
    private static volatile a dIC;

    public static synchronized a aOA() {
        a aVar;
        synchronized (b.class) {
            if (dIC == null) {
                dIC = new a();
            }
            aVar = dIC;
        }
        return aVar;
    }
}
