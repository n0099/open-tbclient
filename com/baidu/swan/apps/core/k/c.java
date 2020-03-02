package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes11.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LruCache<String, Object> bst;

    /* loaded from: classes11.dex */
    private static class a {
        static final c bsu = new c();
    }

    private c() {
        bst = new LruCache<>(10);
    }

    public static c Qv() {
        return a.bsu;
    }

    public synchronized <CONFIG> CONFIG h(String str, CONFIG config) {
        Object obj;
        if (!TextUtils.isEmpty(str) && (obj = bst.get(str)) != null) {
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
            bst.put(str, config);
        }
    }
}
