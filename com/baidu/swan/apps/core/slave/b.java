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
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> cJz = new LinkedList<>();
    private static Map<String, c> cJA = new TreeMap();

    /* loaded from: classes10.dex */
    public static class a {
        public c cJC;
        public final ArrayList<InterfaceC0421b> cJD = new ArrayList<>();
        public long cJE;
        public long cJF;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0421b {
        void onReady();
    }

    public static void bZ(Context context) {
        if (cJz.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            cJz.add(cb(ca(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + cJz.size());
        }
    }

    private static Context ca(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.t.a.aua();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.t.a.aua();
        }
        return context;
    }

    public static a f(@Nullable Activity activity, boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (cJz.isEmpty()) {
            return cb(ca(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + cJz.getFirst());
        }
        a removeFirst = cJz.removeFirst();
        c cVar = removeFirst.cJC;
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
                    b.bZ(f.axo().awY());
                    if (b.DEBUG) {
                        Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
                    }
                }
            }, 600L);
            return removeFirst;
        }
        return removeFirst;
    }

    public static a H(@Nullable Activity activity) {
        return f(activity, false);
    }

    public static void a(a aVar, InterfaceC0421b interfaceC0421b) {
        if (interfaceC0421b != null) {
            if (aVar.isReady) {
                interfaceC0421b.onReady();
            } else {
                aVar.cJD.add(interfaceC0421b);
            }
        }
    }

    private static a cb(Context context) {
        final a aVar = new a();
        aVar.cJE = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.cJC = d.aph().a(context, new g() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // com.baidu.swan.apps.core.g
            public void hO(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.cJC.agj() + " url: " + str);
                }
                a.this.cJF = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.cJD.isEmpty()) {
                    Iterator<InterfaceC0421b> it = a.this.cJD.iterator();
                    while (it.hasNext()) {
                        InterfaceC0421b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.cJD.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = cJA;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c no(@NonNull String str) {
        c cVar = cJA.get(str != null ? str : "");
        if (cVar != null) {
            cJA.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        cJz.clear();
        cJA.clear();
    }
}
