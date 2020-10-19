package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dvV;

    public static synchronized a aKO() {
        a aVar;
        synchronized (b.class) {
            if (dvV == null) {
                dvV = new a();
            }
            aVar = dvV;
        }
        return aVar;
    }
}
