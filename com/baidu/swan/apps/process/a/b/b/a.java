package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dfr;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> dfs = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> dft = new ConcurrentHashMap<>();
    private HandlerC0446a dfu = new HandlerC0446a(Looper.getMainLooper());

    public static a aCx() {
        if (dfr == null) {
            synchronized (a.class) {
                if (dfr == null) {
                    dfr = new a();
                }
            }
        }
        return dfr;
    }

    private a() {
    }

    public void a(com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar) {
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "register a null observer");
                return;
            }
            return;
        }
        String aCw = aVar.aCw();
        if (this.dfs.containsKey(aCw)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aCw);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aCw);
        }
        this.dfs.put(aCw, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aCy()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aCw + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aCw);
            this.dft.put(aCw, bVar);
            this.dfu.postDelayed(bVar, timeoutMillis);
        }
    }

    public void b(com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar) {
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a null observer");
                return;
            }
            return;
        }
        String aCw = aVar.aCw();
        if (!this.dfs.containsKey(aCw)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aCw);
        }
        this.dfs.remove(aCw);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.dfs.get(bVar.aCw());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aCw = aVar.aCw();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aCw);
        }
        aVar.onEvent(bVar);
        if (this.dft.containsKey(aCw)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aCw + " timeout runnable");
            }
            this.dfu.removeCallbacks(this.dft.get(aCw));
            this.dft.remove(aCw);
        }
        if (aVar.aCy()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aCw);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (dfr != null) {
            this.dfs.clear();
            for (Map.Entry<String, Runnable> entry : this.dft.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.dfu.removeCallbacks(entry.getValue());
            }
            this.dft.clear();
            dfr = null;
        }
    }

    /* loaded from: classes10.dex */
    private static class b implements Runnable {
        private String dfq;
        private WeakReference<a> dfv;

        b(a aVar, String str) {
            this.dfv = new WeakReference<>(aVar);
            this.dfq = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.dfv.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.dfq);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.dfq);
                bVar.n(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0446a extends Handler {
        HandlerC0446a(Looper looper) {
            super(looper);
        }
    }
}
