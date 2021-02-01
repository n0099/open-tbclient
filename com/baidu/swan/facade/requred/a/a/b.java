package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a dVQ;

    public static synchronized a aQz() {
        a aVar;
        synchronized (b.class) {
            if (dVQ == null) {
                dVQ = new a();
            }
            aVar = dVQ;
        }
        return aVar;
    }
}
