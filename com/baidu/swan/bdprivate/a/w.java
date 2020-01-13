package com.baidu.swan.bdprivate.a;
/* loaded from: classes5.dex */
public class w {
    private static volatile v bXb;

    public static synchronized v afA() {
        v vVar;
        synchronized (w.class) {
            if (bXb == null) {
                bXb = new v();
            }
            vVar = bXb;
        }
        return vVar;
    }
}
