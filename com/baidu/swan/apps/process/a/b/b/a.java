package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a chW;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> chX = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> chY = new ConcurrentHashMap<>();
    private HandlerC0322a chZ = new HandlerC0322a(Looper.getMainLooper());

    public static a aiQ() {
        if (chW == null) {
            synchronized (a.class) {
                if (chW == null) {
                    chW = new a();
                }
            }
        }
        return chW;
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
        String aiP = aVar.aiP();
        if (this.chX.containsKey(aiP)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aiP);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aiP);
        }
        this.chX.put(aiP, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aiR()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aiP + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aiP);
            this.chY.put(aiP, bVar);
            this.chZ.postDelayed(bVar, timeoutMillis);
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
        String aiP = aVar.aiP();
        if (!this.chX.containsKey(aiP)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aiP);
        }
        this.chX.remove(aiP);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.chX.get(bVar.aiP());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aiP = aVar.aiP();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aiP);
        }
        aVar.onEvent(bVar);
        if (this.chY.containsKey(aiP)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aiP + " timeout runnable");
            }
            this.chZ.removeCallbacks(this.chY.get(aiP));
            this.chY.remove(aiP);
        }
        if (aVar.aiR()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aiP);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (chW != null) {
            this.chX.clear();
            for (Map.Entry<String, Runnable> entry : this.chY.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.chZ.removeCallbacks(entry.getValue());
            }
            this.chY.clear();
            chW = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private String chV;
        private WeakReference<a> cia;

        b(a aVar, String str) {
            this.cia = new WeakReference<>(aVar);
            this.chV = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.cia.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.chV);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.chV);
                bVar.m(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0322a extends Handler {
        HandlerC0322a(Looper looper) {
            super(looper);
        }
    }
}
