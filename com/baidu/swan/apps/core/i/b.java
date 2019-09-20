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
    private static LinkedList<a> atW = new LinkedList<>();
    private static Map<String, com.baidu.swan.apps.b.c.c> atX = new TreeMap();

    /* loaded from: classes2.dex */
    public static class a {
        public com.baidu.swan.apps.b.c.c atZ;
        public boolean aua;
        public final ArrayList<InterfaceC0148b> aub = new ArrayList<>();
    }

    /* renamed from: com.baidu.swan.apps.core.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0148b {
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
        if (atW.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            atW.add(B(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + atW.size());
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
        if (atW.isEmpty()) {
            return B(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + atW.getFirst());
        }
        a removeFirst = atW.removeFirst();
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        ac.c(new Runnable() { // from class: com.baidu.swan.apps.core.i.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.z(com.baidu.swan.apps.w.e.GJ().Gv());
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

    public static void a(a aVar, InterfaceC0148b interfaceC0148b) {
        if (interfaceC0148b != null) {
            if (aVar.aua) {
                interfaceC0148b.onReady();
            } else {
                aVar.aub.add(interfaceC0148b);
            }
        }
    }

    private static a B(Activity activity) {
        final a aVar = new a();
        aVar.aua = false;
        aVar.atZ = com.baidu.swan.apps.core.j.c.BU().a(activity, new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.i.b.3
            @Override // com.baidu.swan.apps.core.c
            public void dy(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.atZ.xz() + " url: " + str);
                }
                a.this.aua = true;
                if (!a.this.aub.isEmpty()) {
                    Iterator<InterfaceC0148b> it = a.this.aub.iterator();
                    while (it.hasNext()) {
                        InterfaceC0148b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.aub.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(String str, com.baidu.swan.apps.b.c.c cVar) {
        atX.put(str, cVar);
    }

    public static com.baidu.swan.apps.b.c.c dZ(String str) {
        com.baidu.swan.apps.b.c.c cVar = atX.get(str);
        if (cVar != null) {
            atX.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        atW.clear();
        atX.clear();
    }
}
