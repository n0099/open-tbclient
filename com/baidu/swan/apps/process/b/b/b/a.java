package com.baidu.swan.apps.process.b.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a aEL;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b>> aEM = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> aEN = new ConcurrentHashMap<>();
    private HandlerC0153a aEO = new HandlerC0153a(Looper.getMainLooper());

    public static a Gl() {
        if (aEL == null) {
            synchronized (a.class) {
                if (aEL == null) {
                    aEL = new a();
                }
            }
        }
        return aEL;
    }

    private a() {
    }

    public void a(com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b> aVar) {
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "register a null observer");
                return;
            }
            return;
        }
        String Gk = aVar.Gk();
        if (this.aEM.containsKey(Gk)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + Gk);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + Gk);
        }
        this.aEM.put(Gk, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.Gm()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + Gk + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, Gk);
            this.aEN.put(Gk, bVar);
            this.aEO.postDelayed(bVar, timeoutMillis);
        }
    }

    public void b(com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b> aVar) {
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a null observer");
                return;
            }
            return;
        }
        String Gk = aVar.Gk();
        if (!this.aEM.containsKey(Gk)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + Gk);
        }
        this.aEM.remove(Gk);
    }

    public void a(@NonNull com.baidu.swan.apps.process.b.b.a.b bVar) {
        com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b> aVar = this.aEM.get(bVar.Gk());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String Gk = aVar.Gk();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + Gk);
        }
        aVar.onEvent(bVar);
        if (this.aEN.containsKey(Gk)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + Gk + " timeout runnable");
            }
            this.aEO.removeCallbacks(this.aEN.get(Gk));
            this.aEN.remove(Gk);
        }
        if (aVar.Gm()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + Gk);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (aEL != null) {
            this.aEM.clear();
            for (Map.Entry<String, Runnable> entry : this.aEN.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.aEO.removeCallbacks(entry.getValue());
            }
            this.aEN.clear();
            aEL = null;
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements Runnable {
        private String aEK;
        private WeakReference<a> aEP;

        b(a aVar, String str) {
            this.aEP = new WeakReference<>(aVar);
            this.aEK = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.aEP.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.aEK);
                }
                com.baidu.swan.apps.process.b.b.a.b bVar = new com.baidu.swan.apps.process.b.b.a.b(this.aEK);
                bVar.h(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.b.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0153a extends Handler {
        HandlerC0153a(Looper looper) {
            super(looper);
        }
    }
}
