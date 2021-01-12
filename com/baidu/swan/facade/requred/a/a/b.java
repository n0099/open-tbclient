package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes6.dex */
public class b {
    private static volatile a dTK;

    public static synchronized a aQg() {
        a aVar;
        synchronized (b.class) {
            if (dTK == null) {
                dTK = new a();
            }
            aVar = dTK;
        }
        return aVar;
    }
}
