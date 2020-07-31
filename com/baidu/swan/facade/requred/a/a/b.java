package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a cYy;

    public static synchronized a azm() {
        a aVar;
        synchronized (b.class) {
            if (cYy == null) {
                cYy = new a();
            }
            aVar = cYy;
        }
        return aVar;
    }
}
