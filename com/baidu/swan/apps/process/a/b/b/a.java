package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dvD;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> dvE = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> dvF = new ConcurrentHashMap<>();
    private HandlerC0460a dvG = new HandlerC0460a(Looper.getMainLooper());

    public static a aIR() {
        if (dvD == null) {
            synchronized (a.class) {
                if (dvD == null) {
                    dvD = new a();
                }
            }
        }
        return dvD;
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
        String aIQ = aVar.aIQ();
        if (this.dvE.containsKey(aIQ)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aIQ);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aIQ);
        }
        this.dvE.put(aIQ, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aIS()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aIQ + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aIQ);
            this.dvF.put(aIQ, bVar);
            this.dvG.postDelayed(bVar, timeoutMillis);
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
        String aIQ = aVar.aIQ();
        if (!this.dvE.containsKey(aIQ)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aIQ);
        }
        this.dvE.remove(aIQ);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.dvE.get(bVar.aIQ());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aIQ = aVar.aIQ();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aIQ);
        }
        aVar.onEvent(bVar);
        if (this.dvF.containsKey(aIQ)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aIQ + " timeout runnable");
            }
            this.dvG.removeCallbacks(this.dvF.get(aIQ));
            this.dvF.remove(aIQ);
        }
        if (aVar.aIS()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aIQ);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (dvD != null) {
            this.dvE.clear();
            for (Map.Entry<String, Runnable> entry : this.dvF.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.dvG.removeCallbacks(entry.getValue());
            }
            this.dvF.clear();
            dvD = null;
        }
    }

    /* loaded from: classes9.dex */
    private static class b implements Runnable {
        private String dvC;
        private WeakReference<a> dvH;

        b(a aVar, String str) {
            this.dvH = new WeakReference<>(aVar);
            this.dvC = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.dvH.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.dvC);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.dvC);
                bVar.k(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class HandlerC0460a extends Handler {
        HandlerC0460a(Looper looper) {
            super(looper);
        }
    }
}
