package com.baidu.swan.apps.ad;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cfS;

    public static synchronized a ahB() {
        a aVar;
        synchronized (b.class) {
            if (cfS == null) {
                cfS = new a();
            }
            aVar = cfS;
        }
        return aVar;
    }
}
