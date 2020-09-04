package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a dhM;

    public static synchronized a aHv() {
        a aVar;
        synchronized (b.class) {
            if (dhM == null) {
                dhM = new a();
            }
            aVar = dhM;
        }
        return aVar;
    }
}
