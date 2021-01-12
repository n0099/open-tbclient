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
    private static volatile a dqO;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> dqP = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> dqQ = new ConcurrentHashMap<>();
    private HandlerC0443a dqR = new HandlerC0443a(Looper.getMainLooper());

    public static a aEX() {
        if (dqO == null) {
            synchronized (a.class) {
                if (dqO == null) {
                    dqO = new a();
                }
            }
        }
        return dqO;
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
        String aEW = aVar.aEW();
        if (this.dqP.containsKey(aEW)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aEW);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aEW);
        }
        this.dqP.put(aEW, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aEY()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aEW + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aEW);
            this.dqQ.put(aEW, bVar);
            this.dqR.postDelayed(bVar, timeoutMillis);
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
        String aEW = aVar.aEW();
        if (!this.dqP.containsKey(aEW)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aEW);
        }
        this.dqP.remove(aEW);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.dqP.get(bVar.aEW());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aEW = aVar.aEW();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aEW);
        }
        aVar.onEvent(bVar);
        if (this.dqQ.containsKey(aEW)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aEW + " timeout runnable");
            }
            this.dqR.removeCallbacks(this.dqQ.get(aEW));
            this.dqQ.remove(aEW);
        }
        if (aVar.aEY()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aEW);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (dqO != null) {
            this.dqP.clear();
            for (Map.Entry<String, Runnable> entry : this.dqQ.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.dqR.removeCallbacks(entry.getValue());
            }
            this.dqQ.clear();
            dqO = null;
        }
    }

    /* loaded from: classes8.dex */
    private static class b implements Runnable {
        private String dqN;
        private WeakReference<a> dqS;

        b(a aVar, String str) {
            this.dqS = new WeakReference<>(aVar);
            this.dqN = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.dqS.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.dqN);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.dqN);
                bVar.k(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class HandlerC0443a extends Handler {
        HandlerC0443a(Looper looper) {
            super(looper);
        }
    }
}
