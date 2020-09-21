package com.baidu.swan.bdprivate.d;
/* loaded from: classes19.dex */
public class c {
    private static volatile b djr;

    public static synchronized b aHG() {
        b bVar;
        synchronized (c.class) {
            if (djr == null) {
                djr = new b();
            }
            bVar = djr;
        }
        return bVar;
    }
}
