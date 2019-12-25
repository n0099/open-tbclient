package com.baidu.swan.bdprivate.address;
/* loaded from: classes4.dex */
public class b {
    private static volatile a bXp;

    public static synchronized a aft() {
        a aVar;
        synchronized (b.class) {
            if (bXp == null) {
                bXp = new a();
            }
            aVar = bXp;
        }
        return aVar;
    }
}
