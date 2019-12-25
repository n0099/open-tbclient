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
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> bmJ = new LinkedList<>();
    private static Map<String, c> bmK = new TreeMap();

    /* loaded from: classes9.dex */
    public static class a {
        public c bmM;
        public boolean bmN;
        public final ArrayList<InterfaceC0243b> bmO = new ArrayList<>();
        public long bmP;
        public long bmQ;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0243b {
        void onReady();
    }

    public static void H(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            if (DEBUG) {
                Log.e("SwanAppSlavePool", "preloadSlaveManager activity is invalid: " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (bmJ.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            bmJ.add(J(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + bmJ.size());
        }
    }

    public static void e(final Activity activity, long j) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager delay ms: " + j);
        }
        ai.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager start.");
                }
                b.H(activity);
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager end.");
                }
            }
        }, j);
    }

    public static a I(Activity activity) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (bmJ.isEmpty()) {
            return J(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + bmJ.getFirst());
        }
        a removeFirst = bmJ.removeFirst();
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        ai.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.H(f.Uf().TQ());
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

    public static void a(a aVar, InterfaceC0243b interfaceC0243b) {
        if (interfaceC0243b != null) {
            if (aVar.bmN) {
                interfaceC0243b.onReady();
            } else {
                aVar.bmO.add(interfaceC0243b);
            }
        }
    }

    private static a J(Activity activity) {
        final a aVar = new a();
        aVar.bmP = System.currentTimeMillis();
        aVar.bmN = false;
        aVar.bmM = d.NK().a(activity, new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.slave.b.3
            @Override // com.baidu.swan.apps.core.b
            public void dV(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.bmM.Ge() + " url: " + str);
                }
                a.this.bmQ = System.currentTimeMillis();
                a.this.bmN = true;
                if (!a.this.bmO.isEmpty()) {
                    Iterator<InterfaceC0243b> it = a.this.bmO.iterator();
                    while (it.hasNext()) {
                        InterfaceC0243b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.bmO.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = bmK;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c ha(@NonNull String str) {
        c cVar = bmK.get(str != null ? str : "");
        if (cVar != null) {
            bmK.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        bmJ.clear();
        bmK.clear();
    }
}
