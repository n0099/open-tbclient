package com.baidu.swan.apps.ad;
/* loaded from: classes5.dex */
public class b {
    private static volatile a bCQ;

    public static synchronized a Xd() {
        a aVar;
        synchronized (b.class) {
            if (bCQ == null) {
                bCQ = new a();
            }
            aVar = bCQ;
        }
        return aVar;
    }
}
