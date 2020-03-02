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
    private static volatile a bIV;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> bIW = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> bIX = new ConcurrentHashMap<>();
    private HandlerC0271a bIY = new HandlerC0271a(Looper.getMainLooper());

    public static a aaJ() {
        if (bIV == null) {
            synchronized (a.class) {
                if (bIV == null) {
                    bIV = new a();
                }
            }
        }
        return bIV;
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
        String aaI = aVar.aaI();
        if (this.bIW.containsKey(aaI)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aaI);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aaI);
        }
        this.bIW.put(aaI, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aaK()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aaI + HanziToPinyin.Token.SEPARATOR + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aaI);
            this.bIX.put(aaI, bVar);
            this.bIY.postDelayed(bVar, timeoutMillis);
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
        String aaI = aVar.aaI();
        if (!this.bIW.containsKey(aaI)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aaI);
        }
        this.bIW.remove(aaI);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.bIW.get(bVar.aaI());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String aaI = aVar.aaI();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + aaI);
        }
        aVar.onEvent(bVar);
        if (this.bIX.containsKey(aaI)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aaI + " timeout runnable");
            }
            this.bIY.removeCallbacks(this.bIX.get(aaI));
            this.bIX.remove(aaI);
        }
        if (aVar.aaK()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + aaI);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (bIV != null) {
            this.bIW.clear();
            for (Map.Entry<String, Runnable> entry : this.bIX.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.bIY.removeCallbacks(entry.getValue());
            }
            this.bIX.clear();
            bIV = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private String bIU;
        private WeakReference<a> bIZ;

        b(a aVar, String str) {
            this.bIZ = new WeakReference<>(aVar);
            this.bIU = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.bIZ.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.bIU);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.bIU);
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
