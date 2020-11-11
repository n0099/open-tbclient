package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a dKk;

    public static synchronized a aPi() {
        a aVar;
        synchronized (b.class) {
            if (dKk == null) {
                dKk = new a();
            }
            aVar = dKk;
        }
        return aVar;
    }
}
