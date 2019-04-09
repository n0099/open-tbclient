package com.baidu.swan.apps.core.h;

import android.app.Activity;
import android.util.Log;
import com.baidu.swan.apps.an.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> asH = new LinkedList<>();
    private static Map<String, com.baidu.swan.apps.b.c.c> asI = new TreeMap();

    /* loaded from: classes2.dex */
    public static class a {
        public com.baidu.swan.apps.b.c.c asK;
        public boolean asL;
        public final ArrayList<InterfaceC0134b> asM = new ArrayList<>();
    }

    /* renamed from: com.baidu.swan.apps.core.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0134b {
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
        if (asH.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            asH.add(y(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + asH.size());
        }
    }

    public static void e(final Activity activity, long j) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager delay ms: " + j);
        }
        aa.b(new Runnable() { // from class: com.baidu.swan.apps.core.h.b.1
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
        if (asH.isEmpty()) {
            return y(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + asH.getFirst());
        }
        a removeFirst = asH.removeFirst();
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        aa.b(new Runnable() { // from class: com.baidu.swan.apps.core.h.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.w(com.baidu.swan.apps.w.e.Ea().DM());
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

    public static void a(a aVar, InterfaceC0134b interfaceC0134b) {
        if (interfaceC0134b != null) {
            if (aVar.asL) {
                interfaceC0134b.onReady();
            } else {
                aVar.asM.add(interfaceC0134b);
            }
        }
    }

    private static a y(Activity activity) {
        final a aVar = new a();
        aVar.asL = false;
        aVar.asK = com.baidu.swan.apps.core.i.c.Aa().a(activity, new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.h.b.3
            @Override // com.baidu.swan.apps.core.c
            public void dF(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.asK.wd() + " url: " + str);
                }
                a.this.asL = true;
                if (!a.this.asM.isEmpty()) {
                    Iterator<InterfaceC0134b> it = a.this.asM.iterator();
                    while (it.hasNext()) {
                        InterfaceC0134b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.asM.clear();
                }
            }
        });
        return aVar;
    }

    public static void b(String str, com.baidu.swan.apps.b.c.c cVar) {
        asI.put(str, cVar);
    }

    public static com.baidu.swan.apps.b.c.c ef(String str) {
        com.baidu.swan.apps.b.c.c cVar = asI.get(str);
        if (cVar != null) {
            asI.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        asH.clear();
        asI.clear();
    }
}
