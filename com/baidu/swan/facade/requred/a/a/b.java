package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cEV;

    public static synchronized a arK() {
        a aVar;
        synchronized (b.class) {
            if (cEV == null) {
                cEV = new a();
            }
            aVar = cEV;
        }
        return aVar;
    }
}
