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
    private static volatile a cIJ;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> cIK = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> cIL = new ConcurrentHashMap<>();
    private HandlerC0420a cIM = new HandlerC0420a(Looper.getMainLooper());

    public static a axj() {
        if (cIJ == null) {
            synchronized (a.class) {
                if (cIJ == null) {
                    cIJ = new a();
                }
            }
        }
        return cIJ;
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
        if (this.cIK.containsKey(axi)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + axi);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + axi);
        }
        this.cIK.put(axi, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.axk()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + axi + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, axi);
            this.cIL.put(axi, bVar);
            this.cIM.postDelayed(bVar, timeoutMillis);
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
        if (!this.cIK.containsKey(axi)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + axi);
        }
        this.cIK.remove(axi);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.cIK.get(bVar.axi());
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
        if (this.cIL.containsKey(axi)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + axi + " timeout runnable");
            }
            this.cIM.removeCallbacks(this.cIL.get(axi));
            this.cIL.remove(axi);
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
        if (cIJ != null) {
            this.cIK.clear();
            for (Map.Entry<String, Runnable> entry : this.cIL.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.cIM.removeCallbacks(entry.getValue());
            }
            this.cIL.clear();
            cIJ = null;
        }
    }

    /* loaded from: classes8.dex */
    private static class b implements Runnable {
        private String cII;
        private WeakReference<a> cIN;

        b(a aVar, String str) {
            this.cIN = new WeakReference<>(aVar);
            this.cII = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.cIN.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.cII);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.cII);
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
