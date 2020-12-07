package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dPA;

    public static synchronized a aRF() {
        a aVar;
        synchronized (b.class) {
            if (dPA == null) {
                dPA = new a();
            }
            aVar = dPA;
        }
        return aVar;
    }
}
