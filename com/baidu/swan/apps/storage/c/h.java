package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> dzr = new HashMap();

    public static b aKk() {
        return tI("searchbox_webapps_sp");
    }

    public static b tI(String str) {
        b bVar = dzr.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = dzr.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    dzr.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
