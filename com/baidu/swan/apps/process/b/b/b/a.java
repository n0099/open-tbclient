package com.baidu.swan.apps.process.b.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.c;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = c.DEBUG;
    private static volatile a aEG;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b>> aEH = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> aEI = new ConcurrentHashMap<>();
    private HandlerC0124a aEJ = new HandlerC0124a(Looper.getMainLooper());

    public static a Gn() {
        if (aEG == null) {
            synchronized (a.class) {
                if (aEG == null) {
                    aEG = new a();
                }
            }
        }
        return aEG;
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
        if (this.aEH.containsKey(Gm)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + Gm);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + Gm);
        }
        this.aEH.put(Gm, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.Go()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + Gm + " " + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, Gm);
            this.aEI.put(Gm, bVar);
            this.aEJ.postDelayed(bVar, timeoutMillis);
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
        if (!this.aEH.containsKey(Gm)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + Gm);
        }
        this.aEH.remove(Gm);
    }

    public void a(@NonNull com.baidu.swan.apps.process.b.b.a.b bVar) {
        com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b> aVar = this.aEH.get(bVar.Gm());
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
        if (this.aEI.containsKey(Gm)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + Gm + " timeout runnable");
            }
            this.aEJ.removeCallbacks(this.aEI.get(Gm));
            this.aEI.remove(Gm);
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
        if (aEG != null) {
            this.aEH.clear();
            for (Map.Entry<String, Runnable> entry : this.aEI.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.aEJ.removeCallbacks(entry.getValue());
            }
            this.aEI.clear();
            aEG = null;
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements Runnable {
        private String aEF;
        private WeakReference<a> aEK;

        b(a aVar, String str) {
            this.aEK = new WeakReference<>(aVar);
            this.aEF = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.aEK.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.aEF);
                }
                com.baidu.swan.apps.process.b.b.a.b bVar = new com.baidu.swan.apps.process.b.b.a.b(this.aEF);
                bVar.h(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.b.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0124a extends Handler {
        HandlerC0124a(Looper looper) {
            super(looper);
        }
    }
}
