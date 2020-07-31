package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a cAA;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> cAB = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> cAC = new ConcurrentHashMap<>();
    private HandlerC0374a cAD = new HandlerC0374a(Looper.getMainLooper());

    public static a apn() {
        if (cAA == null) {
            synchronized (a.class) {
                if (cAA == null) {
                    cAA = new a();
                }
            }
        }
        return cAA;
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
        String apm = aVar.apm();
        if (this.cAB.containsKey(apm)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + apm);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + apm);
        }
        this.cAB.put(apm, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.apo()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + apm + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, apm);
            this.cAC.put(apm, bVar);
            this.cAD.postDelayed(bVar, timeoutMillis);
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
        String apm = aVar.apm();
        if (!this.cAB.containsKey(apm)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + apm);
        }
        this.cAB.remove(apm);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.cAB.get(bVar.apm());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String apm = aVar.apm();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + apm);
        }
        aVar.onEvent(bVar);
        if (this.cAC.containsKey(apm)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + apm + " timeout runnable");
            }
            this.cAD.removeCallbacks(this.cAC.get(apm));
            this.cAC.remove(apm);
        }
        if (aVar.apo()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + apm);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (cAA != null) {
            this.cAB.clear();
            for (Map.Entry<String, Runnable> entry : this.cAC.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.cAD.removeCallbacks(entry.getValue());
            }
            this.cAC.clear();
            cAA = null;
        }
    }

    /* loaded from: classes7.dex */
    private static class b implements Runnable {
        private WeakReference<a> cAE;
        private String cAz;

        b(a aVar, String str) {
            this.cAE = new WeakReference<>(aVar);
            this.cAz = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.cAE.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.cAz);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.cAz);
                bVar.m(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC0374a extends Handler {
        HandlerC0374a(Looper looper) {
            super(looper);
        }
    }
}
