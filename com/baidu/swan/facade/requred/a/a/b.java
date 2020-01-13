package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes5.dex */
public class b {
    private static volatile a cbF;

    public static synchronized a ahj() {
        a aVar;
        synchronized (b.class) {
            if (cbF == null) {
                cbF = new a();
            }
            aVar = cbF;
        }
        return aVar;
    }
}
