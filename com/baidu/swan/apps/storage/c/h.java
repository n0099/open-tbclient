package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> bRi = new HashMap();

    public static b acE() {
        return lV("searchbox_webapps_sp");
    }

    public static b lV(String str) {
        b bVar = bRi.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = bRi.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    bRi.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
