package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> cLS = new HashMap();

    public static b asV() {
        return po("searchbox_webapps_sp");
    }

    public static b po(String str) {
        b bVar = cLS.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = cLS.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    cLS.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
