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
    private static volatile a baG;
    private ConcurrentHashMap<String, com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b>> baH = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Runnable> baI = new ConcurrentHashMap<>();
    private HandlerC0201a baJ = new HandlerC0201a(Looper.getMainLooper());

    public static a On() {
        if (baG == null) {
            synchronized (a.class) {
                if (baG == null) {
                    baG = new a();
                }
            }
        }
        return baG;
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
        String Om = aVar.Om();
        if (this.baH.containsKey(Om)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "multiple register observer：" + Om);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "register observer: " + Om);
        }
        this.baH.put(Om, aVar);
        long timeoutMillis = aVar.getTimeoutMillis();
        if (timeoutMillis > 0 && aVar.Oo()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "post observer: " + Om + HanziToPinyin.Token.SEPARATOR + timeoutMillis + "ms timeout runnable");
            }
            b bVar = new b(this, Om);
            this.baI.put(Om, bVar);
            this.baJ.postDelayed(bVar, timeoutMillis);
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
        String Om = aVar.Om();
        if (!this.baH.containsKey(Om)) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Observe", "unregister observer: " + Om);
        }
        this.baH.remove(Om);
    }

    public void a(@NonNull com.baidu.swan.apps.process.b.b.a.b bVar) {
        com.baidu.swan.apps.process.b.b.c.a<com.baidu.swan.apps.process.b.b.a.b> aVar = this.baH.get(bVar.Om());
        if (aVar == null) {
            if (DEBUG) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String Om = aVar.Om();
        if (DEBUG) {
            Log.d("MDelegate-Observe", "notify observer: " + Om);
        }
        aVar.onEvent(bVar);
        if (this.baI.containsKey(Om)) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "remove observer: " + Om + " timeout runnable");
            }
            this.baJ.removeCallbacks(this.baI.get(Om));
            this.baI.remove(Om);
        }
        if (aVar.Oo()) {
            if (DEBUG) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + Om);
            }
            b(aVar);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (baG != null) {
            this.baH.clear();
            for (Map.Entry<String, Runnable> entry : this.baI.entrySet()) {
                if (DEBUG) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.baJ.removeCallbacks(entry.getValue());
            }
            this.baI.clear();
            baG = null;
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements Runnable {
        private String baF;
        private WeakReference<a> baK;

        b(a aVar, String str) {
            this.baK = new WeakReference<>(aVar);
            this.baF = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.baK.get();
            if (aVar != null) {
                if (a.DEBUG) {
                    Log.d("MDelegate-Observe", "run: observer timeout " + this.baF);
                }
                com.baidu.swan.apps.process.b.b.a.b bVar = new com.baidu.swan.apps.process.b.b.a.b(this.baF);
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
