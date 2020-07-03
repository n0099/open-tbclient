package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes11.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LruCache<String, Object> cfs;

    /* loaded from: classes11.dex */
    private static class a {
        static final c cft = new c();
    }

    private c() {
        cfs = new LruCache<>(10);
    }

    public static c aco() {
        return a.cft;
    }

    public synchronized <CONFIG> CONFIG o(String str, CONFIG config) {
        Object obj;
        if (!TextUtils.isEmpty(str) && (obj = cfs.get(str)) != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
            }
            config = obj;
        }
        return config;
    }

    public synchronized <CONFIG> void p(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            cfs.put(str, config);
        }
    }
}
