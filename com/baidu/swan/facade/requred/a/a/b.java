package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a dhI;

    public static synchronized a aHv() {
        a aVar;
        synchronized (b.class) {
            if (dhI == null) {
                dhI = new a();
            }
            aVar = dhI;
        }
        return aVar;
    }
}
