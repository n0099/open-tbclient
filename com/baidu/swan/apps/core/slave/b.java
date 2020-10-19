package com.baidu.swan.apps.core.slave;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.g;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.v.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> cBd = new LinkedList<>();
    private static Map<String, c> cBe = new TreeMap();

    /* loaded from: classes10.dex */
    public static class a {
        public c cBg;
        public final ArrayList<InterfaceC0407b> cBh = new ArrayList<>();
        public long cBi;
        public long cBj;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0407b {
        void onReady();
    }

    public static void bZ(Context context) {
        if (cBd.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            cBd.add(cb(ca(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + cBd.size());
        }
    }

    private static Context ca(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.t.a.asf();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.t.a.asf();
        }
        return context;
    }

    public static a f(@Nullable Activity activity, boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (cBd.isEmpty()) {
            return cb(ca(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + cBd.getFirst());
        }
        a removeFirst = cBd.removeFirst();
        c cVar = removeFirst.cBg;
        if (cVar != null && activity != null) {
            cVar.attachActivity(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        if (!z) {
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.DEBUG) {
                        Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                    }
                    b.bZ(f.avu().ave());
                    if (b.DEBUG) {
                        Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
                    }
                }
            }, 600L);
            return removeFirst;
        }
        return removeFirst;
    }

    public static a H(@Nullable Activity activity) {
        return f(activity, false);
    }

    public static void a(a aVar, InterfaceC0407b interfaceC0407b) {
        if (interfaceC0407b != null) {
            if (aVar.isReady) {
                interfaceC0407b.onReady();
            } else {
                aVar.cBh.add(interfaceC0407b);
            }
        }
    }

    private static a cb(Context context) {
        final a aVar = new a();
        aVar.cBi = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.cBg = d.ann().a(context, new g() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // com.baidu.swan.apps.core.g
            public void hG(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.cBg.aep() + " url: " + str);
                }
                a.this.cBj = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.cBh.isEmpty()) {
                    Iterator<InterfaceC0407b> it = a.this.cBh.iterator();
                    while (it.hasNext()) {
                        InterfaceC0407b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.cBh.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = cBe;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c mV(@NonNull String str) {
        c cVar = cBe.get(str != null ? str : "");
        if (cVar != null) {
            cBe.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        cBd.clear();
        cBe.clear();
    }
}
