package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes5.dex */
public class c {
    private static volatile b cbG;

    public static synchronized b ahk() {
        b bVar;
        synchronized (c.class) {
            if (cbG == null) {
                cbG = new b();
            }
            bVar = cbG;
        }
        return bVar;
    }
}
