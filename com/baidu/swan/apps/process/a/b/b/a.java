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
    private static volatile a bIU;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> bIV = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> bIW = new ConcurrentHashMap<>();
    private HandlerC0271a bIX = new HandlerC0271a(Looper.getMainLooper());

    public static a aaH() {
        if (bIU == null) {
            synchronized (a.class) {
                if (bIU == null) {
                    bIU = new a();
                }
            }
        }
        return bIU;
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
        String aaG = aVar.aaG();
        if (this.bIV.containsKey(aaG)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aaG);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aaG);
        }
        this.bIV.put(aaG, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aaI()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aaG + HanziToPinyin.Token.SEPARATOR + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aaG);
            this.bIW.put(aaG, bVar);
            this.bIX.postDelayed(bVar, timeoutMillis);
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
        String aaG = aVar.aaG();
        if (!this.bIV.containsKey(aaG)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aaG);
        }
        this.bIV.remove(aaG);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.bIV.get(bVar.aaG());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aaG = aVar.aaG();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aaG);
        }
        aVar.onEvent(bVar);
        if (this.bIW.containsKey(aaG)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aaG + " timeout runnable");
            }
            this.bIX.removeCallbacks(this.bIW.get(aaG));
            this.bIW.remove(aaG);
        }
        if (aVar.aaI()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aaG);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (bIU != null) {
            this.bIV.clear();
            for (Map.Entry<String, Runnable> entry : this.bIW.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.bIX.removeCallbacks(entry.getValue());
            }
            this.bIW.clear();
            bIU = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private String bIT;
        private WeakReference<a> bIY;

        b(a aVar, String str) {
            this.bIY = new WeakReference<>(aVar);
            this.bIT = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.bIY.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.bIT);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.bIT);
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
