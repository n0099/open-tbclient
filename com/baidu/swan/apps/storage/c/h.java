package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> dvg = new HashMap();

    public static b aIs() {
        return tz("searchbox_webapps_sp");
    }

    public static b tz(String str) {
        b bVar = dvg.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = dvg.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    dvg.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
