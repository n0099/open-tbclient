package com.baidu.swan.gamecenter.c;
/* loaded from: classes19.dex */
public class e {
    private static volatile d dOB;

    public static synchronized d aRM() {
        d dVar;
        synchronized (e.class) {
            if (dOB == null) {
                dOB = new d();
            }
            dVar = dOB;
        }
        return dVar;
    }
}
