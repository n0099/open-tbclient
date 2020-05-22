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
    private static volatile a ctm;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> ctn = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> cto = new ConcurrentHashMap<>();
    private HandlerC0365a ctp = new HandlerC0365a(Looper.getMainLooper());

    public static a amx() {
        if (ctm == null) {
            synchronized (a.class) {
                if (ctm == null) {
                    ctm = new a();
                }
            }
        }
        return ctm;
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
        String amw = aVar.amw();
        if (this.ctn.containsKey(amw)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + amw);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + amw);
        }
        this.ctn.put(amw, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.amy()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + amw + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, amw);
            this.cto.put(amw, bVar);
            this.ctp.postDelayed(bVar, timeoutMillis);
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
        String amw = aVar.amw();
        if (!this.ctn.containsKey(amw)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + amw);
        }
        this.ctn.remove(amw);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.ctn.get(bVar.amw());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String amw = aVar.amw();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + amw);
        }
        aVar.onEvent(bVar);
        if (this.cto.containsKey(amw)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + amw + " timeout runnable");
            }
            this.ctp.removeCallbacks(this.cto.get(amw));
            this.cto.remove(amw);
        }
        if (aVar.amy()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + amw);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (ctm != null) {
            this.ctn.clear();
            for (Map.Entry<String, Runnable> entry : this.cto.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.ctp.removeCallbacks(entry.getValue());
            }
            this.cto.clear();
            ctm = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private String ctl;
        private WeakReference<a> ctq;

        b(a aVar, String str) {
            this.ctq = new WeakReference<>(aVar);
            this.ctl = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.ctq.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.ctl);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.ctl);
                bVar.m(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0365a extends Handler {
        HandlerC0365a(Looper looper) {
            super(looper);
        }
    }
}
