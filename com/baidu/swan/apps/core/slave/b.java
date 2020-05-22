package com.baidu.swan.apps.core.slave;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.w.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> bZS = new LinkedList<>();
    private static Map<String, c> bZT = new TreeMap();

    /* loaded from: classes11.dex */
    public static class a {
        public c bZV;
        public final ArrayList<InterfaceC0346b> bZW = new ArrayList<>();
        public long bZX;
        public long bZY;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0346b {
        void onReady();
    }

    public static void bJ(Context context) {
        if (bZS.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            bZS.add(bL(bK(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + bZS.size());
        }
    }

    public static void e(final Activity activity, long j) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager delay ms: " + j);
        }
        aj.c(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager start.");
                }
                b.bJ(activity);
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager end.");
                }
            }
        }, j);
    }

    private static Context bK(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.u.a.aeR();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.u.a.aeR();
        }
        return context;
    }

    public static a F(@Nullable Activity activity) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (bZS.isEmpty()) {
            return bL(bK(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + bZS.getFirst());
        }
        a removeFirst = bZS.removeFirst();
        c cVar = removeFirst.bZV;
        if (cVar != null && activity != null) {
            cVar.attachActivity(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        aj.c(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.bJ(f.ahV().ahF());
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

    public static void a(a aVar, InterfaceC0346b interfaceC0346b) {
        if (interfaceC0346b != null) {
            if (aVar.isReady) {
                interfaceC0346b.onReady();
            } else {
                aVar.bZW.add(interfaceC0346b);
            }
        }
    }

    private static a bL(Context context) {
        final a aVar = new a();
        aVar.bZX = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.bZV = d.abl().a(context, new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.slave.b.3
            @Override // com.baidu.swan.apps.core.b
            public void fQ(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.bZV.Tj() + " url: " + str);
                }
                a.this.bZY = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.bZW.isEmpty()) {
                    Iterator<InterfaceC0346b> it = a.this.bZW.iterator();
                    while (it.hasNext()) {
                        InterfaceC0346b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.bZW.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = bZT;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c jL(@NonNull String str) {
        c cVar = bZT.get(str != null ? str : "");
        if (cVar != null) {
            bZT.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        bZS.clear();
        bZT.clear();
    }
}
