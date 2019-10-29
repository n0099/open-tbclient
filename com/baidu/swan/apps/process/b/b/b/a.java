package com.baidu.swan.apps.process.b.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a baY;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b>> baZ = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> bba = new ConcurrentHashMap<>();
    private HandlerC0201a bbb = new HandlerC0201a(Looper.getMainLooper());

    public static a Om() {
        if (baY == null) {
            synchronized (a.class) {
                if (baY == null) {
                    baY = new a();
                }
            }
        }
        return baY;
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
        String Ol = aVar.Ol();
        if (this.baZ.containsKey(Ol)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + Ol);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + Ol);
        }
        this.baZ.put(Ol, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.On()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + Ol + HanziToPinyin.Token.SEPARATOR + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, Ol);
            this.bba.put(Ol, bVar);
            this.bbb.postDelayed(bVar, timeoutMillis);
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
        String Ol = aVar.Ol();
        if (!this.baZ.containsKey(Ol)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + Ol);
        }
        this.baZ.remove(Ol);
    }

    public void a(@NonNull com.baidu.swan.apps.process.b.b.a.b bVar) {
        com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b> aVar = this.baZ.get(bVar.Ol());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String Ol = aVar.Ol();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + Ol);
        }
        aVar.onEvent(bVar);
        if (this.bba.containsKey(Ol)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + Ol + " timeout runnable");
            }
            this.bbb.removeCallbacks(this.bba.get(Ol));
            this.bba.remove(Ol);
        }
        if (aVar.On()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + Ol);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (baY != null) {
            this.baZ.clear();
            for (Map.Entry<String, Runnable> entry : this.bba.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.bbb.removeCallbacks(entry.getValue());
            }
            this.bba.clear();
            baY = null;
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements Runnable {
        private String baX;
        private WeakReference<a> bbc;

        b(a aVar, String str) {
            this.bbc = new WeakReference<>(aVar);
            this.baX = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.bbc.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.baX);
                }
                com.baidu.swan.apps.process.b.b.a.b bVar = new com.baidu.swan.apps.process.b.b.a.b(this.baX);
                bVar.i(null);
                aVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.b.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0201a extends Handler {
        HandlerC0201a(Looper looper) {
            super(looper);
        }
    }
}
