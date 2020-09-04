package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a cIN;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> cIO = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> cIP = new ConcurrentHashMap<>();
    private HandlerC0420a cIQ = new HandlerC0420a(Looper.getMainLooper());

    public static a axj() {
        if (cIN == null) {
            synchronized (a.class) {
                if (cIN == null) {
                    cIN = new a();
                }
            }
        }
        return cIN;
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
        String axi = aVar.axi();
        if (this.cIO.containsKey(axi)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + axi);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + axi);
        }
        this.cIO.put(axi, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.axk()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + axi + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, axi);
            this.cIP.put(axi, bVar);
            this.cIQ.postDelayed(bVar, timeoutMillis);
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
        String axi = aVar.axi();
        if (!this.cIO.containsKey(axi)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + axi);
        }
        this.cIO.remove(axi);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.cIO.get(bVar.axi());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String axi = aVar.axi();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + axi);
        }
        aVar.onEvent(bVar);
        if (this.cIP.containsKey(axi)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + axi + " timeout runnable");
            }
            this.cIQ.removeCallbacks(this.cIP.get(axi));
            this.cIP.remove(axi);
        }
        if (aVar.axk()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + axi);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (cIN != null) {
            this.cIO.clear();
            for (Map.Entry<String, Runnable> entry : this.cIP.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.cIQ.removeCallbacks(entry.getValue());
            }
            this.cIP.clear();
            cIN = null;
        }
    }

    /* loaded from: classes8.dex */
    private static class b implements Runnable {
        private String cIM;
        private WeakReference<a> cIR;

        b(a aVar, String str) {
            this.cIR = new WeakReference<>(aVar);
            this.cIM = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.cIR.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.cIM);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.cIM);
                bVar.n(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class HandlerC0420a extends Handler {
        HandlerC0420a(Looper looper) {
            super(looper);
        }
    }
}
