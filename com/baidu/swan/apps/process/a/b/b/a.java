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
    private static volatile a cya;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> cyb = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> cyc = new ConcurrentHashMap<>();
    private HandlerC0371a cyd = new HandlerC0371a(Looper.getMainLooper());

    public static a anD() {
        if (cya == null) {
            synchronized (a.class) {
                if (cya == null) {
                    cya = new a();
                }
            }
        }
        return cya;
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
        String anC = aVar.anC();
        if (this.cyb.containsKey(anC)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + anC);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + anC);
        }
        this.cyb.put(anC, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.anE()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + anC + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, anC);
            this.cyc.put(anC, bVar);
            this.cyd.postDelayed(bVar, timeoutMillis);
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
        String anC = aVar.anC();
        if (!this.cyb.containsKey(anC)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + anC);
        }
        this.cyb.remove(anC);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.cyb.get(bVar.anC());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String anC = aVar.anC();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + anC);
        }
        aVar.onEvent(bVar);
        if (this.cyc.containsKey(anC)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + anC + " timeout runnable");
            }
            this.cyd.removeCallbacks(this.cyc.get(anC));
            this.cyc.remove(anC);
        }
        if (aVar.anE()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + anC);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (cya != null) {
            this.cyb.clear();
            for (Map.Entry<String, Runnable> entry : this.cyc.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.cyd.removeCallbacks(entry.getValue());
            }
            this.cyc.clear();
            cya = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private String cxZ;
        private WeakReference<a> cye;

        b(a aVar, String str) {
            this.cye = new WeakReference<>(aVar);
            this.cxZ = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.cye.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.cxZ);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.cxZ);
                bVar.m(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0371a extends Handler {
        HandlerC0371a(Looper looper) {
            super(looper);
        }
    }
}
