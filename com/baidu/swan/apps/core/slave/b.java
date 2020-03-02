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
    private static LinkedList<a> brH = new LinkedList<>();
    private static Map<String, c> brI = new TreeMap();

    /* loaded from: classes11.dex */
    public static class a {
        public c brK;
        public boolean brL;
        public final ArrayList<InterfaceC0255b> brM = new ArrayList<>();
        public long brN;
        public long brO;
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
        if (brH.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            brH.add(L(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + brH.size());
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
        if (brH.isEmpty()) {
            return L(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + brH.getFirst());
        }
        a removeFirst = brH.removeFirst();
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        ai.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.J(f.WS().WD());
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
            if (aVar.brL) {
                interfaceC0255b.onReady();
            } else {
                aVar.brM.add(interfaceC0255b);
            }
        }
    }

    private static a L(Activity activity) {
        final a aVar = new a();
        aVar.brN = System.currentTimeMillis();
        aVar.brL = false;
        aVar.brK = d.Qw().a(activity, new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.slave.b.3
            @Override // com.baidu.swan.apps.core.b
            public void em(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.brK.IR() + " url: " + str);
                }
                a.this.brO = System.currentTimeMillis();
                a.this.brL = true;
                if (!a.this.brM.isEmpty()) {
                    Iterator<InterfaceC0255b> it = a.this.brM.iterator();
                    while (it.hasNext()) {
                        InterfaceC0255b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.brM.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = brI;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c hs(@NonNull String str) {
        c cVar = brI.get(str != null ? str : "");
        if (cVar != null) {
            brI.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        brH.clear();
        brI.clear();
    }
}
