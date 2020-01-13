package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes10.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LruCache<String, Object> boj;

    /* loaded from: classes10.dex */
    private static class a {
        static final c bok = new c();
    }

    private c() {
        boj = new LruCache<>(10);
    }

    public static c Of() {
        return a.bok;
    }

    public synchronized <CONFIG> CONFIG h(String str, CONFIG config) {
        Object obj;
        if (!TextUtils.isEmpty(str) && (obj = boj.get(str)) != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
            }
            config = obj;
        }
        return config;
    }

    public synchronized <CONFIG> void i(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            boj.put(str, config);
        }
    }
}
