package com.baidu.swan.apps.core.slave;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.g;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.v.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes25.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> cUB = new LinkedList<>();
    private static Map<String, c> cUC = new TreeMap();

    /* loaded from: classes25.dex */
    public static class a {
        public c cUE;
        public final ArrayList<InterfaceC0443b> cUF = new ArrayList<>();
        public long cUG;
        public long cUH;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0443b {
        void onReady();
    }

    public static void cF(Context context) {
        if (cUB.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            cUB.add(cH(cG(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + cUB.size());
        }
    }

    private static Context cG(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.t.a.aza();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.t.a.aza();
        }
        return context;
    }

    public static a f(@Nullable Activity activity, boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (cUB.isEmpty()) {
            return cH(cG(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + cUB.getFirst());
        }
        a removeFirst = cUB.removeFirst();
        c cVar = removeFirst.cUE;
        if (cVar != null && activity != null) {
            cVar.attachActivity(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        if (!z) {
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.DEBUG) {
                        Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                    }
                    b.cF(f.aCp().aBZ());
                    if (b.DEBUG) {
                        Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
                    }
                }
            }, 600L);
            return removeFirst;
        }
        return removeFirst;
    }

    public static a G(@Nullable Activity activity) {
        return f(activity, false);
    }

    public static void a(a aVar, InterfaceC0443b interfaceC0443b) {
        if (interfaceC0443b != null) {
            if (aVar.isReady) {
                interfaceC0443b.onReady();
            } else {
                aVar.cUF.add(interfaceC0443b);
            }
        }
    }

    private static a cH(Context context) {
        final a aVar = new a();
        aVar.cUG = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.cUE = d.aui().a(context, new g() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // com.baidu.swan.apps.core.g
            public void it(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.cUE.alj() + " url: " + str);
                }
                a.this.cUH = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.cUF.isEmpty()) {
                    Iterator<InterfaceC0443b> it = a.this.cUF.iterator();
                    while (it.hasNext()) {
                        InterfaceC0443b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.cUF.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = cUC;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c oe(@NonNull String str) {
        c cVar = cUC.get(str != null ? str : "");
        if (cVar != null) {
            cUC.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        cUB.clear();
        cUC.clear();
    }
}
