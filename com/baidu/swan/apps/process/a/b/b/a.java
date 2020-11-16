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
    private static volatile a djF;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> djG = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> djH = new ConcurrentHashMap<>();
    private HandlerC0456a djI = new HandlerC0456a(Looper.getMainLooper());

    public static a aEp() {
        if (djF == null) {
            synchronized (a.class) {
                if (djF == null) {
                    djF = new a();
                }
            }
        }
        return djF;
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
        String aEo = aVar.aEo();
        if (this.djG.containsKey(aEo)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aEo);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aEo);
        }
        this.djG.put(aEo, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aEq()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aEo + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aEo);
            this.djH.put(aEo, bVar);
            this.djI.postDelayed(bVar, timeoutMillis);
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
        String aEo = aVar.aEo();
        if (!this.djG.containsKey(aEo)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aEo);
        }
        this.djG.remove(aEo);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.djG.get(bVar.aEo());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aEo = aVar.aEo();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aEo);
        }
        aVar.onEvent(bVar);
        if (this.djH.containsKey(aEo)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aEo + " timeout runnable");
            }
            this.djI.removeCallbacks(this.djH.get(aEo));
            this.djH.remove(aEo);
        }
        if (aVar.aEq()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aEo);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (djF != null) {
            this.djG.clear();
            for (Map.Entry<String, Runnable> entry : this.djH.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.djI.removeCallbacks(entry.getValue());
            }
            this.djH.clear();
            djF = null;
        }
    }

    /* loaded from: classes7.dex */
    private static class b implements Runnable {
        private String djE;
        private WeakReference<a> djJ;

        b(a aVar, String str) {
            this.djJ = new WeakReference<>(aVar);
            this.djE = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.djJ.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.djE);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.djE);
                bVar.n(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC0456a extends Handler {
        HandlerC0456a(Looper looper) {
            super(looper);
        }
    }
}
