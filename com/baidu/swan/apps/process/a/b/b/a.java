package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dta;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> dtb = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> dtc = new ConcurrentHashMap<>();
    private HandlerC0440a dtd = new HandlerC0440a(Looper.getMainLooper());

    public static a aFs() {
        if (dta == null) {
            synchronized (a.class) {
                if (dta == null) {
                    dta = new a();
                }
            }
        }
        return dta;
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
        String aFr = aVar.aFr();
        if (this.dtb.containsKey(aFr)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aFr);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aFr);
        }
        this.dtb.put(aFr, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aFt()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aFr + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aFr);
            this.dtc.put(aFr, bVar);
            this.dtd.postDelayed(bVar, timeoutMillis);
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
        String aFr = aVar.aFr();
        if (!this.dtb.containsKey(aFr)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aFr);
        }
        this.dtb.remove(aFr);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.dtb.get(bVar.aFr());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aFr = aVar.aFr();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aFr);
        }
        aVar.onEvent(bVar);
        if (this.dtc.containsKey(aFr)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aFr + " timeout runnable");
            }
            this.dtd.removeCallbacks(this.dtc.get(aFr));
            this.dtc.remove(aFr);
        }
        if (aVar.aFt()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aFr);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (dta != null) {
            this.dtb.clear();
            for (Map.Entry<String, Runnable> entry : this.dtc.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.dtd.removeCallbacks(entry.getValue());
            }
            this.dtc.clear();
            dta = null;
        }
    }

    /* loaded from: classes9.dex */
    private static class b implements Runnable {
        private String dsZ;
        private WeakReference<a> dte;

        b(a aVar, String str) {
            this.dte = new WeakReference<>(aVar);
            this.dsZ = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.dte.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.dsZ);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.dsZ);
                bVar.k(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class HandlerC0440a extends Handler {
        HandlerC0440a(Looper looper) {
            super(looper);
        }
    }
}
