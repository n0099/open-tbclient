package com.baidu.swan.impl.map;
/* loaded from: classes20.dex */
public class e {
    private static volatile d ecH;

    public static synchronized d aZk() {
        d dVar;
        synchronized (e.class) {
            if (ecH == null) {
                ecH = new d();
            }
            dVar = ecH;
        }
        return dVar;
    }
}
