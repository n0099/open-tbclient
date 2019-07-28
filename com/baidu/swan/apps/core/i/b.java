package com.baidu.swan.apps.core.i;

import android.app.Activity;
import android.util.Log;
import com.baidu.swan.apps.an.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> aty = new LinkedList<>();
    private static Map<String, com.baidu.swan.apps.b.c.c> atz = new TreeMap();

    /* loaded from: classes2.dex */
    public static class a {
        public com.baidu.swan.apps.b.c.c atB;
        public boolean atC;
        public final ArrayList<InterfaceC0139b> atD = new ArrayList<>();
    }

    /* renamed from: com.baidu.swan.apps.core.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0139b {
        void onReady();
    }

    public static void z(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            if (DEBUG) {
                Log.e("SwanAppSlavePool", "preloadSlaveManager activity is invalid: " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (aty.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            aty.add(B(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + aty.size());
        }
    }

    public static void e(final Activity activity, long j) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager delay ms: " + j);
        }
        ac.c(new Runnable() { // from class: com.baidu.swan.apps.core.i.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager start.");
                }
                b.z(activity);
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager end.");
                }
            }
        }, j);
    }

    public static a A(Activity activity) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (aty.isEmpty()) {
            return B(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + aty.getFirst());
        }
        a removeFirst = aty.removeFirst();
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        ac.c(new Runnable() { // from class: com.baidu.swan.apps.core.i.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.z(com.baidu.swan.apps.w.e.GF().Gr());
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

    public static void a(a aVar, InterfaceC0139b interfaceC0139b) {
        if (interfaceC0139b != null) {
            if (aVar.atC) {
                interfaceC0139b.onReady();
            } else {
                aVar.atD.add(interfaceC0139b);
            }
        }
    }

    private static a B(Activity activity) {
        final a aVar = new a();
        aVar.atC = false;
        aVar.atB = com.baidu.swan.apps.core.j.c.BQ().a(activity, new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.i.b.3
            @Override // com.baidu.swan.apps.core.c
            public void dw(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.atB.xv() + " url: " + str);
                }
                a.this.atC = true;
                if (!a.this.atD.isEmpty()) {
                    Iterator<InterfaceC0139b> it = a.this.atD.iterator();
                    while (it.hasNext()) {
                        InterfaceC0139b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.atD.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(String str, com.baidu.swan.apps.b.c.c cVar) {
        atz.put(str, cVar);
    }

    public static com.baidu.swan.apps.b.c.c dX(String str) {
        com.baidu.swan.apps.b.c.c cVar = atz.get(str);
        if (cVar != null) {
            atz.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        aty.clear();
        atz.clear();
    }
}
