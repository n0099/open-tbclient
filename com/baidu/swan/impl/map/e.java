package com.baidu.swan.impl.map;
/* loaded from: classes6.dex */
public class e {
    private static volatile d emo;

    public static synchronized d bah() {
        d dVar;
        synchronized (e.class) {
            if (emo == null) {
                emo = new d();
            }
            dVar = emo;
        }
        return dVar;
    }
}
