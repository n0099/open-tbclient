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
    private static LinkedList<a> cWY = new LinkedList<>();
    private static Map<String, c> cWZ = new TreeMap();

    /* loaded from: classes9.dex */
    public static class a {
        public c cXb;
        public final ArrayList<InterfaceC0415b> cXc = new ArrayList<>();
        public long cXd;
        public long cXe;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0415b {
        void onReady();
    }

    public static void cL(Context context) {
        if (cWY.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            cWY.add(cN(cM(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + cWY.size());
        }
    }

    private static Context cM(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.t.a.awW();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.t.a.awW();
        }
        return context;
    }

    public static a f(@Nullable Activity activity, boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (cWY.isEmpty()) {
            return cN(cM(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + cWY.getFirst());
        }
        a removeFirst = cWY.removeFirst();
        c cVar = removeFirst.cXb;
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
                    b.cL(f.aAl().azV());
                    if (b.DEBUG) {
                        Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
                    }
                }
            }, 600L);
            return removeFirst;
        }
        return removeFirst;
    }

    public static a z(@Nullable Activity activity) {
        return f(activity, false);
    }

    public static void a(a aVar, InterfaceC0415b interfaceC0415b) {
        if (interfaceC0415b != null) {
            if (aVar.isReady) {
                interfaceC0415b.onReady();
            } else {
                aVar.cXc.add(interfaceC0415b);
            }
        }
    }

    private static a cN(Context context) {
        final a aVar = new a();
        aVar.cXd = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.cXb = d.ase().a(context, new g() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // com.baidu.swan.apps.core.g
            public void iu(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.cXb.aiY() + " url: " + str);
                }
                a.this.cXe = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.cXc.isEmpty()) {
                    Iterator<InterfaceC0415b> it = a.this.cXc.iterator();
                    while (it.hasNext()) {
                        InterfaceC0415b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.cXc.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = cWZ;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c ne(@NonNull String str) {
        c cVar = cWZ.get(str != null ? str : "");
        if (cVar != null) {
            cWZ.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        cWY.clear();
        cWZ.clear();
    }
}
