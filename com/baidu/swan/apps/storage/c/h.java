package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> dmE = new HashMap();

    public static b aGy() {
        return tg("searchbox_webapps_sp");
    }

    public static b tg(String str) {
        b bVar = dmE.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = dmE.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    dmE.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
