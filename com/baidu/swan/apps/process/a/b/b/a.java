package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dqE;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> dqF = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> dqG = new ConcurrentHashMap<>();
    private HandlerC0468a dqH = new HandlerC0468a(Looper.getMainLooper());

    public static a aHx() {
        if (dqE == null) {
            synchronized (a.class) {
                if (dqE == null) {
                    dqE = new a();
                }
            }
        }
        return dqE;
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
        String aHw = aVar.aHw();
        if (this.dqF.containsKey(aHw)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aHw);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aHw);
        }
        this.dqF.put(aHw, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aHy()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aHw + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aHw);
            this.dqG.put(aHw, bVar);
            this.dqH.postDelayed(bVar, timeoutMillis);
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
        String aHw = aVar.aHw();
        if (!this.dqF.containsKey(aHw)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aHw);
        }
        this.dqF.remove(aHw);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.dqF.get(bVar.aHw());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aHw = aVar.aHw();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aHw);
        }
        aVar.onEvent(bVar);
        if (this.dqG.containsKey(aHw)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aHw + " timeout runnable");
            }
            this.dqH.removeCallbacks(this.dqG.get(aHw));
            this.dqG.remove(aHw);
        }
        if (aVar.aHy()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aHw);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (dqE != null) {
            this.dqF.clear();
            for (Map.Entry<String, Runnable> entry : this.dqG.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.dqH.removeCallbacks(entry.getValue());
            }
            this.dqG.clear();
            dqE = null;
        }
    }

    /* loaded from: classes25.dex */
    private static class b implements Runnable {
        private String dqD;
        private WeakReference<a> dqI;

        b(a aVar, String str) {
            this.dqI = new WeakReference<>(aVar);
            this.dqD = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.dqI.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.dqD);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.dqD);
                bVar.n(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class HandlerC0468a extends Handler {
        HandlerC0468a(Looper looper) {
            super(looper);
        }
    }
}
