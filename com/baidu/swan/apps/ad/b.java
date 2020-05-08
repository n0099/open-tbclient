package com.baidu.swan.apps.ad;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cfY;

    public static synchronized a ahA() {
        a aVar;
        synchronized (b.class) {
            if (cfY == null) {
                cfY = new a();
            }
            aVar = cfY;
        }
        return aVar;
    }
}
