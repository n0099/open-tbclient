package com.baidu.swan.bdprivate.d;
/* loaded from: classes6.dex */
public class c {
    private static volatile b dWP;

    public static synchronized b aQe() {
        b bVar;
        synchronized (c.class) {
            if (dWP == null) {
                dWP = new b();
            }
            bVar = dWP;
        }
        return bVar;
    }
}
