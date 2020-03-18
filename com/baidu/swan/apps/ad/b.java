package com.baidu.swan.apps.ad;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bHj;

    public static synchronized a Zw() {
        a aVar;
        synchronized (b.class) {
            if (bHj == null) {
                bHj = new a();
            }
            aVar = bHj;
        }
        return aVar;
    }
}
