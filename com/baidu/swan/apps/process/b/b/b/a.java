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
    private static volatile a aGE;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b>> aGF = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> aGG = new ConcurrentHashMap<>();
    private HandlerC0158a aGH = new HandlerC0158a(Looper.getMainLooper());

    public static a IB() {
        if (aGE == null) {
            synchronized (a.class) {
                if (aGE == null) {
                    aGE = new a();
                }
            }
        }
        return aGE;
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
        String IA = aVar.IA();
        if (this.aGF.containsKey(IA)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + IA);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + IA);
        }
        this.aGF.put(IA, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.IC()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + IA + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, IA);
            this.aGG.put(IA, bVar);
            this.aGH.postDelayed(bVar, timeoutMillis);
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
        String IA = aVar.IA();
        if (!this.aGF.containsKey(IA)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + IA);
        }
        this.aGF.remove(IA);
    }

    public void a(@NonNull com.baidu.swan.apps.process.b.b.a.b bVar) {
        com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b> aVar = this.aGF.get(bVar.IA());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String IA = aVar.IA();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + IA);
        }
        aVar.onEvent(bVar);
        if (this.aGG.containsKey(IA)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + IA + " timeout runnable");
            }
            this.aGH.removeCallbacks(this.aGG.get(IA));
            this.aGG.remove(IA);
        }
        if (aVar.IC()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + IA);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (aGE != null) {
            this.aGF.clear();
            for (Map.Entry<String, Runnable> entry : this.aGG.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.aGH.removeCallbacks(entry.getValue());
            }
            this.aGG.clear();
            aGE = null;
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements Runnable {
        private String aGD;
        private WeakReference<a> aGI;

        b(a aVar, String str) {
            this.aGI = new WeakReference<>(aVar);
            this.aGD = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.aGI.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.aGD);
                }
                com.baidu.swan.apps.process.b.b.a.b bVar = new com.baidu.swan.apps.process.b.b.a.b(this.aGD);
                bVar.i(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.b.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0158a extends Handler {
        HandlerC0158a(Looper looper) {
            super(looper);
        }
    }
}
