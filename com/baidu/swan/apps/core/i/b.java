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
    private static LinkedList<a> aMV = new LinkedList<>();
    private static Map<String, com.baidu.swan.apps.b.c.c> aMW = new TreeMap();

    /* loaded from: classes2.dex */
    public static class a {
        public com.baidu.swan.apps.b.c.c aMY;
        public boolean aMZ;
        public final ArrayList<InterfaceC0180b> aNa = new ArrayList<>();
    }

    /* renamed from: com.baidu.swan.apps.core.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0180b {
        void onReady();
    }

    public static void y(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            if (DEBUG) {
                Log.e("SwanAppSlavePool", "preloadSlaveManager activity is invalid: " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (aMV.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            aMV.add(A(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + aMV.size());
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
                b.y(activity);
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager end.");
                }
            }
        }, j);
    }

    public static a z(Activity activity) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (aMV.isEmpty()) {
            return A(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + aMV.getFirst());
        }
        a removeFirst = aMV.removeFirst();
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        ac.c(new Runnable() { // from class: com.baidu.swan.apps.core.i.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.y(com.baidu.swan.apps.w.e.LE().Lq());
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

    public static void a(a aVar, InterfaceC0180b interfaceC0180b) {
        if (interfaceC0180b != null) {
            if (aVar.aMZ) {
                interfaceC0180b.onReady();
            } else {
                aVar.aNa.add(interfaceC0180b);
            }
        }
    }

    private static a A(Activity activity) {
        final a aVar = new a();
        aVar.aMZ = false;
        aVar.aMY = com.baidu.swan.apps.core.j.c.GP().a(activity, new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.i.b.3
            @Override // com.baidu.swan.apps.core.c
            public void db(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.aMY.Cu() + " url: " + str);
                }
                a.this.aMZ = true;
                if (!a.this.aNa.isEmpty()) {
                    Iterator<InterfaceC0180b> it = a.this.aNa.iterator();
                    while (it.hasNext()) {
                        InterfaceC0180b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.aNa.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(String str, com.baidu.swan.apps.b.c.c cVar) {
        aMW.put(str, cVar);
    }

    public static com.baidu.swan.apps.b.c.c eG(String str) {
        com.baidu.swan.apps.b.c.c cVar = aMW.get(str);
        if (cVar != null) {
            aMW.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        aMV.clear();
        aMW.clear();
    }
}
