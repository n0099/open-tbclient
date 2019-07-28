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
    private static volatile a aHm;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b>> aHn = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> aHo = new ConcurrentHashMap<>();
    private HandlerC0160a aHp = new HandlerC0160a(Looper.getMainLooper());

    public static a Jo() {
        if (aHm == null) {
            synchronized (a.class) {
                if (aHm == null) {
                    aHm = new a();
                }
            }
        }
        return aHm;
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
        String Jn = aVar.Jn();
        if (this.aHn.containsKey(Jn)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + Jn);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + Jn);
        }
        this.aHn.put(Jn, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.Jp()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + Jn + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, Jn);
            this.aHo.put(Jn, bVar);
            this.aHp.postDelayed(bVar, timeoutMillis);
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
        String Jn = aVar.Jn();
        if (!this.aHn.containsKey(Jn)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + Jn);
        }
        this.aHn.remove(Jn);
    }

    public void a(@NonNull com.baidu.swan.apps.process.b.b.a.b bVar) {
        com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b> aVar = this.aHn.get(bVar.Jn());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String Jn = aVar.Jn();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + Jn);
        }
        aVar.onEvent(bVar);
        if (this.aHo.containsKey(Jn)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + Jn + " timeout runnable");
            }
            this.aHp.removeCallbacks(this.aHo.get(Jn));
            this.aHo.remove(Jn);
        }
        if (aVar.Jp()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + Jn);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (aHm != null) {
            this.aHn.clear();
            for (Map.Entry<String, Runnable> entry : this.aHo.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.aHp.removeCallbacks(entry.getValue());
            }
            this.aHo.clear();
            aHm = null;
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements Runnable {
        private String aHl;
        private WeakReference<a> aHq;

        b(a aVar, String str) {
            this.aHq = new WeakReference<>(aVar);
            this.aHl = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.aHq.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.aHl);
                }
                com.baidu.swan.apps.process.b.b.a.b bVar = new com.baidu.swan.apps.process.b.b.a.b(this.aHl);
                bVar.i(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.b.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0160a extends Handler {
        HandlerC0160a(Looper looper) {
            super(looper);
        }
    }
}
