package com.baidu.swan.impl.map;
/* loaded from: classes4.dex */
public class e {
    private static volatile d crd;

    public static synchronized d aoT() {
        d dVar;
        synchronized (e.class) {
            if (crd == null) {
                crd = new d();
            }
            dVar = crd;
        }
        return dVar;
    }
}
