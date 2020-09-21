package com.baidu.swan.bdprivate.b;
/* loaded from: classes19.dex */
public class c {
    private static volatile b dhw;

    public static synchronized b aHe() {
        b bVar;
        synchronized (c.class) {
            if (dhw == null) {
                dhw = new b();
            }
            bVar = dhw;
        }
        return bVar;
    }
}
