package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cTV;

    public static synchronized a awy() {
        a aVar;
        synchronized (b.class) {
            if (cTV == null) {
                cTV = new a();
            }
            aVar = cTV;
        }
        return aVar;
    }
}
