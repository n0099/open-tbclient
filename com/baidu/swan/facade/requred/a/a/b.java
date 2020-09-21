package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes19.dex */
public class b {
    private static volatile a djP;

    public static synchronized a aIf() {
        a aVar;
        synchronized (b.class) {
            if (djP == null) {
                djP = new a();
            }
            aVar = djP;
        }
        return aVar;
    }
}
