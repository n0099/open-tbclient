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
    private static LinkedList<a> brG = new LinkedList<>();
    private static Map<String, c> brH = new TreeMap();

    /* loaded from: classes11.dex */
    public static class a {
        public c brJ;
        public boolean brK;
        public final ArrayList<InterfaceC0255b> brL = new ArrayList<>();
        public long brM;
        public long brN;
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
        if (brG.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            brG.add(L(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + brG.size());
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
        if (brG.isEmpty()) {
            return L(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + brG.getFirst());
        }
        a removeFirst = brG.removeFirst();
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        ai.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.J(f.WQ().WB());
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
            if (aVar.brK) {
                interfaceC0255b.onReady();
            } else {
                aVar.brL.add(interfaceC0255b);
            }
        }
    }

    private static a L(Activity activity) {
        final a aVar = new a();
        aVar.brM = System.currentTimeMillis();
        aVar.brK = false;
        aVar.brJ = d.Qu().a(activity, new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.slave.b.3
            @Override // com.baidu.swan.apps.core.b
            public void em(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.brJ.IP() + " url: " + str);
                }
                a.this.brN = System.currentTimeMillis();
                a.this.brK = true;
                if (!a.this.brL.isEmpty()) {
                    Iterator<InterfaceC0255b> it = a.this.brL.iterator();
                    while (it.hasNext()) {
                        InterfaceC0255b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.brL.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = brH;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c hs(@NonNull String str) {
        c cVar = brH.get(str != null ? str : "");
        if (cVar != null) {
            brH.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        brG.clear();
        brH.clear();
    }
}
