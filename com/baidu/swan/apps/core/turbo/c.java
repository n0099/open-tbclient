package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes8.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LruCache<String, Object> cVw;

    /* loaded from: classes8.dex */
    private static class a {
        static final c cVx = new c();
    }

    private c() {
        cVw = new LruCache<>(10);
    }

    public static c arC() {
        return a.cVx;
    }

    public synchronized <CONFIG> CONFIG n(String str, CONFIG config) {
        Object obj;
        if (!TextUtils.isEmpty(str) && (obj = cVw.get(str)) != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
            }
            config = obj;
        }
        return config;
    }

    public synchronized <CONFIG> void o(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            cVw.put(str, config);
        }
    }
}
