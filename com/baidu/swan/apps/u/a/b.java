package com.baidu.swan.apps.u.a;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final LruCache<String, Object> cYi;

    /* loaded from: classes10.dex */
    private static class a {
        static final b cYj = new b();
    }

    private b() {
        this.cYi = new LruCache<>(10);
    }

    public static b ayk() {
        return a.cYj;
    }

    public synchronized <RESULT> RESULT pa(String str) {
        RESULT result = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.cYi.get(str);
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
            this.cYi.put(str, result);
        }
    }

    public synchronized void pb(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("SwanAppLaunchCache", "removeConfig key: " + str);
            }
            this.cYi.remove(str);
        }
    }

    public synchronized void clear() {
        if (this.cYi != null) {
            this.cYi.evictAll();
        }
    }
}
