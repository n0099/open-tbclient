package com.baidu.swan.apps.z;
/* loaded from: classes20.dex */
public class b {
    private static volatile a cTM;

    public static synchronized a ayJ() {
        a aVar;
        synchronized (b.class) {
            if (cTM == null) {
                cTM = new a();
            }
            aVar = cTM;
        }
        return aVar;
    }
}
