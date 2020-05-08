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
    private static LinkedList<a> bQg = new LinkedList<>();
    private static Map<String, c> bQh = new TreeMap();

    /* loaded from: classes11.dex */
    public static class a {
        public c bQj;
        public final ArrayList<InterfaceC0306b> bQk = new ArrayList<>();
        public long bQl;
        public long bQm;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0306b {
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
        if (bQg.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            bQg.add(H(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + bQg.size());
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
        if (bQg.isEmpty()) {
            return H(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + bQg.getFirst());
        }
        a removeFirst = bQg.removeFirst();
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        ai.c(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.F(f.aeJ().aeu());
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

    public static void a(a aVar, InterfaceC0306b interfaceC0306b) {
        if (interfaceC0306b != null) {
            if (aVar.isReady) {
                interfaceC0306b.onReady();
            } else {
                aVar.bQk.add(interfaceC0306b);
            }
        }
    }

    private static a H(Activity activity) {
        final a aVar = new a();
        aVar.bQl = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.bQj = d.Yn().a(activity, new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.slave.b.3
            @Override // com.baidu.swan.apps.core.b
            public void fe(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.bQj.QF() + " url: " + str);
                }
                a.this.bQm = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.bQk.isEmpty()) {
                    Iterator<InterfaceC0306b> it = a.this.bQk.iterator();
                    while (it.hasNext()) {
                        InterfaceC0306b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.bQk.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = bQh;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c iF(@NonNull String str) {
        c cVar = bQh.get(str != null ? str : "");
        if (cVar != null) {
            bQh.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        bQg.clear();
        bQh.clear();
    }
}
