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
    private static volatile a bIW;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b>> bIX = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> bIY = new ConcurrentHashMap<>();
    private HandlerC0271a bIZ = new HandlerC0271a(Looper.getMainLooper());

    public static a aaJ() {
        if (bIW == null) {
            synchronized (a.class) {
                if (bIW == null) {
                    bIW = new a();
                }
            }
        }
        return bIW;
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
        if (this.bIX.containsKey(aaI)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + aaI);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + aaI);
        }
        this.bIX.put(aaI, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.aaK()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + aaI + HanziToPinyin.Token.SEPARATOR + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, aaI);
            this.bIY.put(aaI, bVar);
            this.bIZ.postDelayed(bVar, timeoutMillis);
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
        if (!this.bIX.containsKey(aaI)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + aaI);
        }
        this.bIX.remove(aaI);
    }

    public void a(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        com.baidu.swan.apps.process.a.b.c.a<com.baidu.swan.apps.process.a.b.a.b> aVar = this.bIX.get(bVar.aaI());
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
        if (this.bIY.containsKey(aaI)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + aaI + " timeout runnable");
            }
            this.bIZ.removeCallbacks(this.bIY.get(aaI));
            this.bIY.remove(aaI);
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
        if (bIW != null) {
            this.bIX.clear();
            for (Map.Entry<String, Runnable> entry : this.bIY.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.bIZ.removeCallbacks(entry.getValue());
            }
            this.bIY.clear();
            bIW = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private String bIV;
        private WeakReference<a> bJa;

        b(a aVar, String str) {
            this.bJa = new WeakReference<>(aVar);
            this.bIV = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.bJa.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.bIV);
                }
                com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(this.bIV);
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
