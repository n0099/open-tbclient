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
    private static LinkedList<a> cPs = new LinkedList<>();
    private static Map<String, c> cPt = new TreeMap();

    /* loaded from: classes10.dex */
    public static class a {
        public c cPv;
        public final ArrayList<InterfaceC0433b> cPw = new ArrayList<>();
        public long cPx;
        public long cPy;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0433b {
        void onReady();
    }

    public static void bZ(Context context) {
        if (cPs.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            cPs.add(cb(ca(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + cPs.size());
        }
    }

    private static Context ca(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.t.a.awA();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.t.a.awA();
        }
        return context;
    }

    public static a f(@Nullable Activity activity, boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (cPs.isEmpty()) {
            return cb(ca(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + cPs.getFirst());
        }
        a removeFirst = cPs.removeFirst();
        c cVar = removeFirst.cPv;
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
                    b.bZ(f.azO().azy());
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

    public static void a(a aVar, InterfaceC0433b interfaceC0433b) {
        if (interfaceC0433b != null) {
            if (aVar.isReady) {
                interfaceC0433b.onReady();
            } else {
                aVar.cPw.add(interfaceC0433b);
            }
        }
    }

    private static a cb(Context context) {
        final a aVar = new a();
        aVar.cPx = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.cPv = d.arI().a(context, new g() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // com.baidu.swan.apps.core.g
            public void hV(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.cPv.aiJ() + " url: " + str);
                }
                a.this.cPy = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.cPw.isEmpty()) {
                    Iterator<InterfaceC0433b> it = a.this.cPw.iterator();
                    while (it.hasNext()) {
                        InterfaceC0433b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.cPw.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = cPt;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c nD(@NonNull String str) {
        c cVar = cPt.get(str != null ? str : "");
        if (cVar != null) {
            cPt.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        cPs.clear();
        cPt.clear();
    }
}
