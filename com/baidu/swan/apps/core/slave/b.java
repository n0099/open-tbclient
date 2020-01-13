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
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> bnx = new LinkedList<>();
    private static Map<String, c> bny = new TreeMap();

    /* loaded from: classes10.dex */
    public static class a {
        public c bnA;
        public boolean bnB;
        public final ArrayList<InterfaceC0245b> bnC = new ArrayList<>();
        public long bnD;
        public long bnE;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0245b {
        void onReady();
    }

    public static void I(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            if (DEBUG) {
                Log.e("SwanAppSlavePool", "preloadSlaveManager activity is invalid: " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (bnx.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            bnx.add(K(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + bnx.size());
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
                b.I(activity);
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager end.");
                }
            }
        }, j);
    }

    public static a J(Activity activity) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (bnx.isEmpty()) {
            return K(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + bnx.getFirst());
        }
        a removeFirst = bnx.removeFirst();
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        ai.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.I(f.UC().Un());
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

    public static void a(a aVar, InterfaceC0245b interfaceC0245b) {
        if (interfaceC0245b != null) {
            if (aVar.bnB) {
                interfaceC0245b.onReady();
            } else {
                aVar.bnC.add(interfaceC0245b);
            }
        }
    }

    private static a K(Activity activity) {
        final a aVar = new a();
        aVar.bnD = System.currentTimeMillis();
        aVar.bnB = false;
        aVar.bnA = d.Og().a(activity, new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.slave.b.3
            @Override // com.baidu.swan.apps.core.b
            public void dX(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.bnA.GA() + " url: " + str);
                }
                a.this.bnE = System.currentTimeMillis();
                a.this.bnB = true;
                if (!a.this.bnC.isEmpty()) {
                    Iterator<InterfaceC0245b> it = a.this.bnC.iterator();
                    while (it.hasNext()) {
                        InterfaceC0245b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.bnC.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = bny;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c hd(@NonNull String str) {
        c cVar = bny.get(str != null ? str : "");
        if (cVar != null) {
            bny.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        bnx.clear();
        bny.clear();
    }
}
