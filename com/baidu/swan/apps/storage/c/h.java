package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> bWj = new HashMap();

    public static b afu() {
        return mm("searchbox_webapps_sp");
    }

    public static b mm(String str) {
        b bVar = bWj.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = bWj.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    bWj.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
