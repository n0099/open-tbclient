package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a chQ;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> chR = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> chS = new ConcurrentHashMap<>();
    private HandlerC0301a chT = new HandlerC0301a(Looper.getMainLooper());

    public static a aiR() {
        if (chQ == null) {
            synchronized (a.class) {
                if (chQ == null) {
                    chQ = new a();
                }
            }
        }
        return chQ;
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
        String aiQ = aVar.aiQ();
        if (this.chR.containsKey(aiQ)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aiQ);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aiQ);
        }
        this.chR.put(aiQ, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aiS()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aiQ + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aiQ);
            this.chS.put(aiQ, bVar);
            this.chT.postDelayed(bVar, timeoutMillis);
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
        String aiQ = aVar.aiQ();
        if (!this.chR.containsKey(aiQ)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aiQ);
        }
        this.chR.remove(aiQ);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.chR.get(bVar.aiQ());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aiQ = aVar.aiQ();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aiQ);
        }
        aVar.onEvent(bVar);
        if (this.chS.containsKey(aiQ)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aiQ + " timeout runnable");
            }
            this.chT.removeCallbacks(this.chS.get(aiQ));
            this.chS.remove(aiQ);
        }
        if (aVar.aiS()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aiQ);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (chQ != null) {
            this.chR.clear();
            for (Map.Entry<String, Runnable> entry : this.chS.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.chT.removeCallbacks(entry.getValue());
            }
            this.chS.clear();
            chQ = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private String chP;
        private WeakReference<a> chU;

        b(a aVar, String str) {
            this.chU = new WeakReference<>(aVar);
            this.chP = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.chU.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.chP);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.chP);
                bVar.l(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0301a extends Handler {
        HandlerC0301a(Looper looper) {
            super(looper);
        }
    }
}
