package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cPl;

    public static synchronized a avs() {
        a aVar;
        synchronized (b.class) {
            if (cPl == null) {
                cPl = new a();
            }
            aVar = cPl;
        }
        return aVar;
    }
}
