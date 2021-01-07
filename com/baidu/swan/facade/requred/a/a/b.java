package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a dYw;

    public static synchronized a aUa() {
        a aVar;
        synchronized (b.class) {
            if (dYw == null) {
                dYw = new a();
            }
            aVar = dYw;
        }
        return aVar;
    }
}
