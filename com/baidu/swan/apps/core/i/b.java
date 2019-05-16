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
    private static LinkedList<a> asV = new LinkedList<>();
    private static Map<String, com.baidu.swan.apps.b.c.c> asW = new TreeMap();

    /* loaded from: classes2.dex */
    public static class a {
        public com.baidu.swan.apps.b.c.c asY;
        public boolean asZ;
        public final ArrayList<InterfaceC0137b> ata = new ArrayList<>();
    }

    /* renamed from: com.baidu.swan.apps.core.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0137b {
        void onReady();
    }

    public static void w(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            if (DEBUG) {
                Log.e("SwanAppSlavePool", "preloadSlaveManager activity is invalid: " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (asV.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            asV.add(y(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + asV.size());
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
                b.w(activity);
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager end.");
                }
            }
        }, j);
    }

    public static a x(Activity activity) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (asV.isEmpty()) {
            return y(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + asV.getFirst());
        }
        a removeFirst = asV.removeFirst();
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        ac.c(new Runnable() { // from class: com.baidu.swan.apps.core.i.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.w(com.baidu.swan.apps.w.e.FV().FH());
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

    public static void a(a aVar, InterfaceC0137b interfaceC0137b) {
        if (interfaceC0137b != null) {
            if (aVar.asZ) {
                interfaceC0137b.onReady();
            } else {
                aVar.ata.add(interfaceC0137b);
            }
        }
    }

    private static a y(Activity activity) {
        final a aVar = new a();
        aVar.asZ = false;
        aVar.asY = com.baidu.swan.apps.core.j.c.Bi().a(activity, new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.i.b.3
            @Override // com.baidu.swan.apps.core.c
            public void ds(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.asY.wU() + " url: " + str);
                }
                a.this.asZ = true;
                if (!a.this.ata.isEmpty()) {
                    Iterator<InterfaceC0137b> it = a.this.ata.iterator();
                    while (it.hasNext()) {
                        InterfaceC0137b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.ata.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(String str, com.baidu.swan.apps.b.c.c cVar) {
        asW.put(str, cVar);
    }

    public static com.baidu.swan.apps.b.c.c dT(String str) {
        com.baidu.swan.apps.b.c.c cVar = asW.get(str);
        if (cVar != null) {
            asW.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        asV.clear();
        asW.clear();
    }
}
