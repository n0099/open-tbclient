package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes8.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LruCache<String, Object> cZi;

    /* loaded from: classes8.dex */
    private static class a {
        static final c cZj = new c();
    }

    private c() {
        cZi = new LruCache<>(10);
    }

    public static c asd() {
        return a.cZj;
    }

    public synchronized <CONFIG> CONFIG m(String str, CONFIG config) {
        Object obj;
        if (!TextUtils.isEmpty(str) && (obj = cZi.get(str)) != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
            }
            config = obj;
        }
        return config;
    }

    public synchronized <CONFIG> void n(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            cZi.put(str, config);
        }
    }
}
