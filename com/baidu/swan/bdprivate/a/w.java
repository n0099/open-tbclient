package com.baidu.swan.bdprivate.a;
/* loaded from: classes4.dex */
public class w {
    private static volatile v bWP;

    public static synchronized v afh() {
        v vVar;
        synchronized (w.class) {
            if (bWP == null) {
                bWP = new v();
            }
            vVar = bWP;
        }
        return vVar;
    }
}
