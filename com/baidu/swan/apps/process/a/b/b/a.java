package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a bEP;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> bEQ = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> bER = new ConcurrentHashMap<>();
    private HandlerC0261a bES = new HandlerC0261a(Looper.getMainLooper());

    public static a Yt() {
        if (bEP == null) {
            synchronized (a.class) {
                if (bEP == null) {
                    bEP = new a();
                }
            }
        }
        return bEP;
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
        String Ys = aVar.Ys();
        if (this.bEQ.containsKey(Ys)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + Ys);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + Ys);
        }
        this.bEQ.put(Ys, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.Yu()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + Ys + HanziToPinyin.Token.SEPARATOR + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, Ys);
            this.bER.put(Ys, bVar);
            this.bES.postDelayed(bVar, timeoutMillis);
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
        String Ys = aVar.Ys();
        if (!this.bEQ.containsKey(Ys)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + Ys);
        }
        this.bEQ.remove(Ys);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.bEQ.get(bVar.Ys());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String Ys = aVar.Ys();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + Ys);
        }
        aVar.onEvent(bVar);
        if (this.bER.containsKey(Ys)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + Ys + " timeout runnable");
            }
            this.bES.removeCallbacks(this.bER.get(Ys));
            this.bER.remove(Ys);
        }
        if (aVar.Yu()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + Ys);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (bEP != null) {
            this.bEQ.clear();
            for (Map.Entry<String, Runnable> entry : this.bER.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.bES.removeCallbacks(entry.getValue());
            }
            this.bER.clear();
            bEP = null;
        }
    }

    /* loaded from: classes10.dex */
    private static class b implements Runnable {
        private String bEO;
        private WeakReference<a> bET;

        b(a aVar, String str) {
            this.bET = new WeakReference<>(aVar);
            this.bEO = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.bET.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.bEO);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.bEO);
                bVar.l(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0261a extends Handler {
        HandlerC0261a(Looper looper) {
            super(looper);
        }
    }
}
