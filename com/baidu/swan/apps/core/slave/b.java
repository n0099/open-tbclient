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
    private static LinkedList<a> brU = new LinkedList<>();
    private static Map<String, c> brV = new TreeMap();

    /* loaded from: classes11.dex */
    public static class a {
        public c brX;
        public boolean brY;
        public final ArrayList<InterfaceC0255b> brZ = new ArrayList<>();
        public long bsa;
        public long bsb;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0255b {
        void onReady();
    }

    public static void J(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            if (DEBUG) {
                Log.e("SwanAppSlavePool", "preloadSlaveManager activity is invalid: " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (brU.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            brU.add(L(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + brU.size());
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
                b.J(activity);
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager end.");
                }
            }
        }, j);
    }

    public static a K(Activity activity) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (brU.isEmpty()) {
            return L(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + brU.getFirst());
        }
        a removeFirst = brU.removeFirst();
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        ai.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.J(f.WV().WG());
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

    public static void a(a aVar, InterfaceC0255b interfaceC0255b) {
        if (interfaceC0255b != null) {
            if (aVar.brY) {
                interfaceC0255b.onReady();
            } else {
                aVar.brZ.add(interfaceC0255b);
            }
        }
    }

    private static a L(Activity activity) {
        final a aVar = new a();
        aVar.bsa = System.currentTimeMillis();
        aVar.brY = false;
        aVar.brX = d.Qz().a(activity, new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.slave.b.3
            @Override // com.baidu.swan.apps.core.b
            public void el(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.brX.IU() + " url: " + str);
                }
                a.this.bsb = System.currentTimeMillis();
                a.this.brY = true;
                if (!a.this.brZ.isEmpty()) {
                    Iterator<InterfaceC0255b> it = a.this.brZ.iterator();
                    while (it.hasNext()) {
                        InterfaceC0255b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.brZ.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = brV;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c hr(@NonNull String str) {
        c cVar = brV.get(str != null ? str : "");
        if (cVar != null) {
            brV.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        brU.clear();
        brV.clear();
    }
}
