package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> cHi = new HashMap();

    public static b arO() {
        return pg("searchbox_webapps_sp");
    }

    public static b pg(String str) {
        b bVar = cHi.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = cHi.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    cHi.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
