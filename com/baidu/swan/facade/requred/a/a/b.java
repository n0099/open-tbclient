package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dEs;

    public static synchronized a aMI() {
        a aVar;
        synchronized (b.class) {
            if (dEs == null) {
                dEs = new a();
            }
            aVar = dEs;
        }
        return aVar;
    }
}
