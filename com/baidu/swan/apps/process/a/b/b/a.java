package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a duC;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> duD = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> duE = new ConcurrentHashMap<>();
    private HandlerC0446a duF = new HandlerC0446a(Looper.getMainLooper());

    public static a aFv() {
        if (duC == null) {
            synchronized (a.class) {
                if (duC == null) {
                    duC = new a();
                }
            }
        }
        return duC;
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
        String aFu = aVar.aFu();
        if (this.duD.containsKey(aFu)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aFu);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aFu);
        }
        this.duD.put(aFu, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aFw()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aFu + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aFu);
            this.duE.put(aFu, bVar);
            this.duF.postDelayed(bVar, timeoutMillis);
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
        String aFu = aVar.aFu();
        if (!this.duD.containsKey(aFu)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aFu);
        }
        this.duD.remove(aFu);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.duD.get(bVar.aFu());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aFu = aVar.aFu();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aFu);
        }
        aVar.onEvent(bVar);
        if (this.duE.containsKey(aFu)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aFu + " timeout runnable");
            }
            this.duF.removeCallbacks(this.duE.get(aFu));
            this.duE.remove(aFu);
        }
        if (aVar.aFw()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aFu);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (duC != null) {
            this.duD.clear();
            for (Map.Entry<String, Runnable> entry : this.duE.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.duF.removeCallbacks(entry.getValue());
            }
            this.duE.clear();
            duC = null;
        }
    }

    /* loaded from: classes8.dex */
    private static class b implements Runnable {
        private String duB;
        private WeakReference<a> duG;

        b(a aVar, String str) {
            this.duG = new WeakReference<>(aVar);
            this.duB = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.duG.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.duB);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.duB);
                bVar.m(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class HandlerC0446a extends Handler {
        HandlerC0446a(Looper looper) {
            super(looper);
        }
    }
}
