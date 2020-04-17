package com.baidu.swan.apps.core.slave;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.k.d;
import com.baidu.swan.apps.y.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> bQb = new LinkedList<>();
    private static Map<String, c> bQc = new TreeMap();

    /* loaded from: classes11.dex */
    public static class a {
        public c bQe;
        public final ArrayList<InterfaceC0285b> bQf = new ArrayList<>();
        public long bQg;
        public long bQh;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0285b {
        void onReady();
    }

    public static void F(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            if (DEBUG) {
                Log.e("SwanAppSlavePool", "preloadSlaveManager activity is invalid: " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (bQb.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            bQb.add(H(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + bQb.size());
        }
    }

    public static void e(final Activity activity, long j) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager delay ms: " + j);
        }
        ai.c(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager start.");
                }
                b.F(activity);
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager end.");
                }
            }
        }, j);
    }

    public static a G(Activity activity) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (bQb.isEmpty()) {
            return H(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + bQb.getFirst());
        }
        a removeFirst = bQb.removeFirst();
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        ai.c(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.F(f.aeK().aev());
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
                }
            }
        }, 600L);
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager return.");
            return removeFirst;
        }
        return removeFirst;
    }

    public static void a(a aVar, InterfaceC0285b interfaceC0285b) {
        if (interfaceC0285b != null) {
            if (aVar.isReady) {
                interfaceC0285b.onReady();
            } else {
                aVar.bQf.add(interfaceC0285b);
            }
        }
    }

    private static a H(Activity activity) {
        final a aVar = new a();
        aVar.bQg = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.bQe = d.Yo().a(activity, new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.slave.b.3
            @Override // com.baidu.swan.apps.core.b
            public void fe(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.bQe.QG() + " url: " + str);
                }
                a.this.bQh = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.bQf.isEmpty()) {
                    Iterator<InterfaceC0285b> it = a.this.bQf.iterator();
                    while (it.hasNext()) {
                        InterfaceC0285b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.bQf.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = bQc;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c iF(@NonNull String str) {
        c cVar = bQc.get(str != null ? str : "");
        if (cVar != null) {
            bQc.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        bQb.clear();
        bQc.clear();
    }
}
