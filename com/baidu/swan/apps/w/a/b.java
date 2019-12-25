package com.baidu.swan.apps.w.a;
/* loaded from: classes4.dex */
public class b {
    private static volatile a bsW;

    public static synchronized a Sq() {
        a aVar;
        synchronized (b.class) {
            if (bsW == null) {
                bsW = new a();
            }
            aVar = bsW;
        }
        return aVar;
    }
}
