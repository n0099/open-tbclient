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
    private static LinkedList<a> ceI = new LinkedList<>();
    private static Map<String, c> ceJ = new TreeMap();

    /* loaded from: classes11.dex */
    public static class a {
        public c ceL;
        public final ArrayList<InterfaceC0352b> ceM = new ArrayList<>();
        public long ceN;
        public long ceO;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0352b {
        void onReady();
    }

    public static void bK(Context context) {
        if (ceI.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            ceI.add(bM(bL(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + ceI.size());
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
                b.bK(activity);
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager end.");
                }
            }
        }, j);
    }

    private static Context bL(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.u.a.afX();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.u.a.afX();
        }
        return context;
    }

    public static a F(@Nullable Activity activity) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (ceI.isEmpty()) {
            return bM(bL(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + ceI.getFirst());
        }
        a removeFirst = ceI.removeFirst();
        c cVar = removeFirst.ceL;
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
                b.bK(f.ajb().aiL());
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

    public static void a(a aVar, InterfaceC0352b interfaceC0352b) {
        if (interfaceC0352b != null) {
            if (aVar.isReady) {
                interfaceC0352b.onReady();
            } else {
                aVar.ceM.add(interfaceC0352b);
            }
        }
    }

    private static a bM(Context context) {
        final a aVar = new a();
        aVar.ceN = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.ceL = d.acr().a(context, new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.slave.b.3
            @Override // com.baidu.swan.apps.core.b
            public void fJ(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.ceL.Up() + " url: " + str);
                }
                a.this.ceO = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.ceM.isEmpty()) {
                    Iterator<InterfaceC0352b> it = a.this.ceM.iterator();
                    while (it.hasNext()) {
                        InterfaceC0352b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.ceM.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = ceJ;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c jT(@NonNull String str) {
        c cVar = ceJ.get(str != null ? str : "");
        if (cVar != null) {
            ceJ.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        ceI.clear();
        ceJ.clear();
    }
}
