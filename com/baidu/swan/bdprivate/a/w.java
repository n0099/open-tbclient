package com.baidu.swan.bdprivate.a;
/* loaded from: classes14.dex */
public class w {
    private static volatile v cWg;

    public static synchronized v ayh() {
        v vVar;
        synchronized (w.class) {
            if (cWg == null) {
                cWg = new v();
            }
            vVar = cWg;
        }
        return vVar;
    }
}
