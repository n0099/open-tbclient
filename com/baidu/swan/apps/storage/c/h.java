package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> cPn = new HashMap();

    public static b auW() {
        return pZ("searchbox_webapps_sp");
    }

    public static b pZ(String str) {
        b bVar = cPn.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = cPn.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    cPn.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
