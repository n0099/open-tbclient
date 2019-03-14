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
    private static volatile a aEH;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b>> aEI = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> aEJ = new ConcurrentHashMap<>();
    private HandlerC0153a aEK = new HandlerC0153a(Looper.getMainLooper());

    public static a Gn() {
        if (aEH == null) {
            synchronized (a.class) {
                if (aEH == null) {
                    aEH = new a();
                }
            }
        }
        return aEH;
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
        String Gm = aVar.Gm();
        if (this.aEI.containsKey(Gm)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + Gm);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + Gm);
        }
        this.aEI.put(Gm, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.Go()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + Gm + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, Gm);
            this.aEJ.put(Gm, bVar);
            this.aEK.postDelayed(bVar, timeoutMillis);
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
        String Gm = aVar.Gm();
        if (!this.aEI.containsKey(Gm)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + Gm);
        }
        this.aEI.remove(Gm);
    }

    public void a(@NonNull com.baidu.swan.apps.process.b.b.a.b bVar) {
        com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b> aVar = this.aEI.get(bVar.Gm());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String Gm = aVar.Gm();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + Gm);
        }
        aVar.onEvent(bVar);
        if (this.aEJ.containsKey(Gm)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + Gm + " timeout runnable");
            }
            this.aEK.removeCallbacks(this.aEJ.get(Gm));
            this.aEJ.remove(Gm);
        }
        if (aVar.Go()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + Gm);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (aEH != null) {
            this.aEI.clear();
            for (Map.Entry<String, Runnable> entry : this.aEJ.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.aEK.removeCallbacks(entry.getValue());
            }
            this.aEJ.clear();
            aEH = null;
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements Runnable {
        private String aEG;
        private WeakReference<a> aEL;

        b(a aVar, String str) {
            this.aEL = new WeakReference<>(aVar);
            this.aEG = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.aEL.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.aEG);
                }
                com.baidu.swan.apps.process.b.b.a.b bVar = new com.baidu.swan.apps.process.b.b.a.b(this.aEG);
                bVar.h(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.b.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0153a extends Handler {
        HandlerC0153a(Looper looper) {
            super(looper);
        }
    }
}
