package com.baidu.swan.apps.process.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a bJh;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> bJi = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> bJj = new ConcurrentHashMap<>();
    private HandlerC0271a bJk = new HandlerC0271a(Looper.getMainLooper());

    public static a aaM() {
        if (bJh == null) {
            synchronized (a.class) {
                if (bJh == null) {
                    bJh = new a();
                }
            }
        }
        return bJh;
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
        String aaL = aVar.aaL();
        if (this.bJi.containsKey(aaL)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aaL);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aaL);
        }
        this.bJi.put(aaL, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aaN()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aaL + HanziToPinyin.Token.SEPARATOR + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aaL);
            this.bJj.put(aaL, bVar);
            this.bJk.postDelayed(bVar, timeoutMillis);
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
        String aaL = aVar.aaL();
        if (!this.bJi.containsKey(aaL)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aaL);
        }
        this.bJi.remove(aaL);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.bJi.get(bVar.aaL());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aaL = aVar.aaL();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aaL);
        }
        aVar.onEvent(bVar);
        if (this.bJj.containsKey(aaL)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aaL + " timeout runnable");
            }
            this.bJk.removeCallbacks(this.bJj.get(aaL));
            this.bJj.remove(aaL);
        }
        if (aVar.aaN()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aaL);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (bJh != null) {
            this.bJi.clear();
            for (Map.Entry<String, Runnable> entry : this.bJj.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.bJk.removeCallbacks(entry.getValue());
            }
            this.bJj.clear();
            bJh = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private String bJg;
        private WeakReference<a> bJl;

        b(a aVar, String str) {
            this.bJl = new WeakReference<>(aVar);
            this.bJg = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.bJl.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.bJg);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.bJg);
                bVar.l(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0271a extends Handler {
        HandlerC0271a(Looper looper) {
            super(looper);
        }
    }
}
