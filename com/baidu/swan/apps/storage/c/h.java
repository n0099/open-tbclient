package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> dav = new HashMap();

    public static b aDP() {
        return su("searchbox_webapps_sp");
    }

    public static b su(String str) {
        b bVar = dav.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = dav.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    dav.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
