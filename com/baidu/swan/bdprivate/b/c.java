package com.baidu.swan.bdprivate.b;
/* loaded from: classes14.dex */
public class c {
    private static volatile b dfw;

    public static synchronized b aGu() {
        b bVar;
        synchronized (c.class) {
            if (dfw == null) {
                dfw = new b();
            }
            bVar = dfw;
        }
        return bVar;
    }
}
