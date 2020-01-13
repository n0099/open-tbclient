package com.baidu.swan.bdprivate.address;
/* loaded from: classes5.dex */
public class b {
    private static volatile a bXB;

    public static synchronized a afM() {
        a aVar;
        synchronized (b.class) {
            if (bXB == null) {
                bXB = new a();
            }
            aVar = bXB;
        }
        return aVar;
    }
}
