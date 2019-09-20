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
    private static volatile a aHK;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b>> aHL = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> aHM = new ConcurrentHashMap<>();
    private HandlerC0169a aHN = new HandlerC0169a(Looper.getMainLooper());

    public static a Js() {
        if (aHK == null) {
            synchronized (a.class) {
                if (aHK == null) {
                    aHK = new a();
                }
            }
        }
        return aHK;
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
        String Jr = aVar.Jr();
        if (this.aHL.containsKey(Jr)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + Jr);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + Jr);
        }
        this.aHL.put(Jr, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.Jt()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + Jr + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, Jr);
            this.aHM.put(Jr, bVar);
            this.aHN.postDelayed(bVar, timeoutMillis);
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
        String Jr = aVar.Jr();
        if (!this.aHL.containsKey(Jr)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + Jr);
        }
        this.aHL.remove(Jr);
    }

    public void a(@NonNull com.baidu.swan.apps.process.b.b.a.b bVar) {
        com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b> aVar = this.aHL.get(bVar.Jr());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String Jr = aVar.Jr();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + Jr);
        }
        aVar.onEvent(bVar);
        if (this.aHM.containsKey(Jr)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + Jr + " timeout runnable");
            }
            this.aHN.removeCallbacks(this.aHM.get(Jr));
            this.aHM.remove(Jr);
        }
        if (aVar.Jt()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + Jr);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (aHK != null) {
            this.aHL.clear();
            for (Map.Entry<String, Runnable> entry : this.aHM.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.aHN.removeCallbacks(entry.getValue());
            }
            this.aHM.clear();
            aHK = null;
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements Runnable {
        private String aHJ;
        private WeakReference<a> aHO;

        b(a aVar, String str) {
            this.aHO = new WeakReference<>(aVar);
            this.aHJ = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.aHO.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.aHJ);
                }
                com.baidu.swan.apps.process.b.b.a.b bVar = new com.baidu.swan.apps.process.b.b.a.b(this.aHJ);
                bVar.i(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.b.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0169a extends Handler {
        HandlerC0169a(Looper looper) {
            super(looper);
        }
    }
}
