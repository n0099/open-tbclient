package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a cKN;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> cKO = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> cKP = new ConcurrentHashMap<>();
    private HandlerC0415a cKQ = new HandlerC0415a(Looper.getMainLooper());

    public static a axS() {
        if (cKN == null) {
            synchronized (a.class) {
                if (cKN == null) {
                    cKN = new a();
                }
            }
        }
        return cKN;
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
        String axR = aVar.axR();
        if (this.cKO.containsKey(axR)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + axR);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + axR);
        }
        this.cKO.put(axR, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.axT()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + axR + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, axR);
            this.cKP.put(axR, bVar);
            this.cKQ.postDelayed(bVar, timeoutMillis);
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
        String axR = aVar.axR();
        if (!this.cKO.containsKey(axR)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + axR);
        }
        this.cKO.remove(axR);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.cKO.get(bVar.axR());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String axR = aVar.axR();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + axR);
        }
        aVar.onEvent(bVar);
        if (this.cKP.containsKey(axR)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + axR + " timeout runnable");
            }
            this.cKQ.removeCallbacks(this.cKP.get(axR));
            this.cKP.remove(axR);
        }
        if (aVar.axT()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + axR);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (cKN != null) {
            this.cKO.clear();
            for (Map.Entry<String, Runnable> entry : this.cKP.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.cKQ.removeCallbacks(entry.getValue());
            }
            this.cKP.clear();
            cKN = null;
        }
    }

    /* loaded from: classes3.dex */
    private static class b implements Runnable {
        private String cKM;
        private WeakReference<a> cKR;

        b(a aVar, String str) {
            this.cKR = new WeakReference<>(aVar);
            this.cKM = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.cKR.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.cKM);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.cKM);
                bVar.n(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0415a extends Handler {
        HandlerC0415a(Looper looper) {
            super(looper);
        }
    }
}
