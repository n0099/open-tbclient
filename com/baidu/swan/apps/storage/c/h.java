package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> dAY = new HashMap();

    public static b aKS() {
        return tN("searchbox_webapps_sp");
    }

    public static b tN(String str) {
        b bVar = dAY.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = dAY.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    dAY.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
