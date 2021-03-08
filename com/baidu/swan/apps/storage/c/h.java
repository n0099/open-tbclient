package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> dNN = new HashMap();

    public static b aMk() {
        return tB("searchbox_webapps_sp");
    }

    public static b tB(String str) {
        b bVar = dNN.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = dNN.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    dNN.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
