package com.baidu.swan.apps.t.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a dft;

    public static synchronized a ayq() {
        a aVar;
        synchronized (b.class) {
            if (dft == null) {
                dft = new a();
            }
            aVar = dft;
        }
        return aVar;
    }
}
