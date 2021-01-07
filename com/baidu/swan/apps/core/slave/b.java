package com.baidu.swan.apps.core.slave;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.g;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.v.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> cZx = new LinkedList<>();
    private static Map<String, c> cZy = new TreeMap();

    /* loaded from: classes9.dex */
    public static class a {
        public c cZA;
        public final ArrayList<InterfaceC0435b> cZB = new ArrayList<>();
        public long cZC;
        public long cZD;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0435b {
        void onReady();
    }

    public static void cN(Context context) {
        if (cZx.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            cZx.add(cP(cO(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + cZx.size());
        }
    }

    private static Context cO(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.t.a.aAs();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.t.a.aAs();
        }
        return context;
    }

    public static a f(@Nullable Activity activity, boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (cZx.isEmpty()) {
            return cP(cO(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + cZx.getFirst());
        }
        a removeFirst = cZx.removeFirst();
        c cVar = removeFirst.cZA;
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
                    b.cN(f.aDH().aDr());
                    if (b.DEBUG) {
                        Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
                    }
                }
            }, 600L);
            return removeFirst;
        }
        return removeFirst;
    }

    public static a F(@Nullable Activity activity) {
        return f(activity, false);
    }

    public static void a(a aVar, InterfaceC0435b interfaceC0435b) {
        if (interfaceC0435b != null) {
            if (aVar.isReady) {
                interfaceC0435b.onReady();
            } else {
                aVar.cZB.add(interfaceC0435b);
            }
        }
    }

    private static a cP(Context context) {
        final a aVar = new a();
        aVar.cZC = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.cZA = d.avB().a(context, new g() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // com.baidu.swan.apps.core.g
            public void ig(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.cZA.amu() + " url: " + str);
                }
                a.this.cZD = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.cZB.isEmpty()) {
                    Iterator<InterfaceC0435b> it = a.this.cZB.iterator();
                    while (it.hasNext()) {
                        InterfaceC0435b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.cZB.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = cZy;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c nX(@NonNull String str) {
        c cVar = cZy.get(str != null ? str : "");
        if (cVar != null) {
            cZy.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        cZx.clear();
        cZy.clear();
    }
}
