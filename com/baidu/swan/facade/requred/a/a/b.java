package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cFb;

    public static synchronized a arJ() {
        a aVar;
        synchronized (b.class) {
            if (cFb == null) {
                cFb = new a();
            }
            aVar = cFb;
        }
        return aVar;
    }
}
