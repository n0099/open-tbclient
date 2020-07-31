package com.baidu.swan.apps.u.a;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final LruCache<String, Object> cod;

    /* loaded from: classes7.dex */
    private static class a {
        static final b coe = new b();
    }

    private b() {
        this.cod = new LruCache<>(10);
    }

    public static b aiO() {
        return a.coe;
    }

    public synchronized <RESULT> RESULT lo(String str) {
        RESULT result = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.cod.get(str);
                if (obj == null) {
                    if (DEBUG) {
                        Log.d("SwanAppLaunchCache", "doesn't hit the cache result, key = " + str);
                    }
                } else {
                    try {
                        if (DEBUG) {
                            Log.d("SwanAppLaunchCache", "hit the cache result, key = " + str);
                        }
                        result = obj;
                    } catch (Exception e) {
                        if (DEBUG) {
                            Log.e("SwanAppLaunchCache", Log.getStackTraceString(e));
                        }
                    }
                }
            }
        }
        return result;
    }

    public synchronized <RESULT> void p(String str, RESULT result) {
        if (!TextUtils.isEmpty(str) && result != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchCache", "putConfig key: " + str);
            }
            this.cod.put(str, result);
        }
    }

    public synchronized void lp(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("SwanAppLaunchCache", "removeConfig key: " + str);
            }
            this.cod.remove(str);
        }
    }

    public synchronized void clear() {
        if (this.cod != null) {
            this.cod.evictAll();
        }
    }
}
