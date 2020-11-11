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
    private static volatile a dlm;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> dln = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> dlo = new ConcurrentHashMap<>();
    private HandlerC0458a dlp = new HandlerC0458a(Looper.getMainLooper());

    public static a aEX() {
        if (dlm == null) {
            synchronized (a.class) {
                if (dlm == null) {
                    dlm = new a();
                }
            }
        }
        return dlm;
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
        String aEW = aVar.aEW();
        if (this.dln.containsKey(aEW)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aEW);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aEW);
        }
        this.dln.put(aEW, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aEY()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aEW + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aEW);
            this.dlo.put(aEW, bVar);
            this.dlp.postDelayed(bVar, timeoutMillis);
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
        String aEW = aVar.aEW();
        if (!this.dln.containsKey(aEW)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aEW);
        }
        this.dln.remove(aEW);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.dln.get(bVar.aEW());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aEW = aVar.aEW();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aEW);
        }
        aVar.onEvent(bVar);
        if (this.dlo.containsKey(aEW)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aEW + " timeout runnable");
            }
            this.dlp.removeCallbacks(this.dlo.get(aEW));
            this.dlo.remove(aEW);
        }
        if (aVar.aEY()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aEW);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (dlm != null) {
            this.dln.clear();
            for (Map.Entry<String, Runnable> entry : this.dlo.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.dlp.removeCallbacks(entry.getValue());
            }
            this.dlo.clear();
            dlm = null;
        }
    }

    /* loaded from: classes10.dex */
    private static class b implements Runnable {
        private String dll;
        private WeakReference<a> dlq;

        b(a aVar, String str) {
            this.dlq = new WeakReference<>(aVar);
            this.dll = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.dlq.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.dll);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.dll);
                bVar.n(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0458a extends Handler {
        HandlerC0458a(Looper looper) {
            super(looper);
        }
    }
}
