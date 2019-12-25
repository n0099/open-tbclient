package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a bEe;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> bEf = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> bEg = new ConcurrentHashMap<>();
    private HandlerC0259a bEh = new HandlerC0259a(Looper.getMainLooper());

    public static a XW() {
        if (bEe == null) {
            synchronized (a.class) {
                if (bEe == null) {
                    bEe = new a();
                }
            }
        }
        return bEe;
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
        String XV = aVar.XV();
        if (this.bEf.containsKey(XV)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + XV);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + XV);
        }
        this.bEf.put(XV, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.XX()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + XV + HanziToPinyin.Token.SEPARATOR + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, XV);
            this.bEg.put(XV, bVar);
            this.bEh.postDelayed(bVar, timeoutMillis);
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
        String XV = aVar.XV();
        if (!this.bEf.containsKey(XV)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + XV);
        }
        this.bEf.remove(XV);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.bEf.get(bVar.XV());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String XV = aVar.XV();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + XV);
        }
        aVar.onEvent(bVar);
        if (this.bEg.containsKey(XV)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + XV + " timeout runnable");
            }
            this.bEh.removeCallbacks(this.bEg.get(XV));
            this.bEg.remove(XV);
        }
        if (aVar.XX()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + XV);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (bEe != null) {
            this.bEf.clear();
            for (Map.Entry<String, Runnable> entry : this.bEg.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.bEh.removeCallbacks(entry.getValue());
            }
            this.bEg.clear();
            bEe = null;
        }
    }

    /* loaded from: classes9.dex */
    private static class b implements Runnable {
        private String bEd;
        private WeakReference<a> bEi;

        b(a aVar, String str) {
            this.bEi = new WeakReference<>(aVar);
            this.bEd = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.bEi.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.bEd);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.bEd);
                bVar.l(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class HandlerC0259a extends Handler {
        HandlerC0259a(Looper looper) {
            super(looper);
        }
    }
}
