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
    private static volatile a cWQ;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> cWR = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> cWS = new ConcurrentHashMap<>();
    private HandlerC0432a cWT = new HandlerC0432a(Looper.getMainLooper());

    public static a aAD() {
        if (cWQ == null) {
            synchronized (a.class) {
                if (cWQ == null) {
                    cWQ = new a();
                }
            }
        }
        return cWQ;
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
        String aAC = aVar.aAC();
        if (this.cWR.containsKey(aAC)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aAC);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aAC);
        }
        this.cWR.put(aAC, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aAE()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aAC + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aAC);
            this.cWS.put(aAC, bVar);
            this.cWT.postDelayed(bVar, timeoutMillis);
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
        String aAC = aVar.aAC();
        if (!this.cWR.containsKey(aAC)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aAC);
        }
        this.cWR.remove(aAC);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.cWR.get(bVar.aAC());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aAC = aVar.aAC();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aAC);
        }
        aVar.onEvent(bVar);
        if (this.cWS.containsKey(aAC)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aAC + " timeout runnable");
            }
            this.cWT.removeCallbacks(this.cWS.get(aAC));
            this.cWS.remove(aAC);
        }
        if (aVar.aAE()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aAC);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (cWQ != null) {
            this.cWR.clear();
            for (Map.Entry<String, Runnable> entry : this.cWS.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.cWT.removeCallbacks(entry.getValue());
            }
            this.cWS.clear();
            cWQ = null;
        }
    }

    /* loaded from: classes10.dex */
    private static class b implements Runnable {
        private String cWP;
        private WeakReference<a> cWU;

        b(a aVar, String str) {
            this.cWU = new WeakReference<>(aVar);
            this.cWP = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.cWU.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.cWP);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.cWP);
                bVar.n(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0432a extends Handler {
        HandlerC0432a(Looper looper) {
            super(looper);
        }
    }
}
