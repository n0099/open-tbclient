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
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> cmL = new LinkedList<>();
    private static Map<String, c> cmM = new TreeMap();

    /* loaded from: classes8.dex */
    public static class a {
        public c cmO;
        public final ArrayList<InterfaceC0395b> cmP = new ArrayList<>();
        public long cmQ;
        public long cmR;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0395b {
        void onReady();
    }

    public static void bU(Context context) {
        if (cmL.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            cmL.add(bW(bV(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + cmL.size());
        }
    }

    private static Context bV(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.t.a.aoJ();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.t.a.aoJ();
        }
        return context;
    }

    public static a f(@Nullable Activity activity, boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (cmL.isEmpty()) {
            return bW(bV(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + cmL.getFirst());
        }
        a removeFirst = cmL.removeFirst();
        c cVar = removeFirst.cmO;
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
                    b.bU(f.arY().arI());
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

    public static void a(a aVar, InterfaceC0395b interfaceC0395b) {
        if (interfaceC0395b != null) {
            if (aVar.isReady) {
                interfaceC0395b.onReady();
            } else {
                aVar.cmP.add(interfaceC0395b);
            }
        }
    }

    private static a bW(Context context) {
        final a aVar = new a();
        aVar.cmQ = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.cmO = d.ajS().a(context, new g() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // com.baidu.swan.apps.core.g
            public void ht(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.cmO.aaU() + " url: " + str);
                }
                a.this.cmR = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.cmP.isEmpty()) {
                    Iterator<InterfaceC0395b> it = a.this.cmP.iterator();
                    while (it.hasNext()) {
                        InterfaceC0395b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.cmP.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = cmM;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c lQ(@NonNull String str) {
        c cVar = cmM.get(str != null ? str : "");
        if (cVar != null) {
            cmM.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        cmL.clear();
        cmM.clear();
    }
}
