package com.baidu.swan.apps.core.slave;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.core.e;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.v.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> cgt = new LinkedList<>();
    private static Map<String, c> cgu = new TreeMap();

    /* loaded from: classes7.dex */
    public static class a {
        public c cgw;
        public final ArrayList<InterfaceC0353b> cgx = new ArrayList<>();
        public long cgy;
        public long cgz;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0353b {
        void onReady();
    }

    public static void bN(Context context) {
        if (cgt.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            cgt.add(bP(bO(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + cgt.size());
        }
    }

    public static void e(final Activity activity, long j) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager delay ms: " + j);
        }
        al.c(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager start.");
                }
                b.bN(activity);
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager end.");
                }
            }
        }, j);
    }

    private static Context bO(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.t.a.ahj();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.t.a.ahj();
        }
        return context;
    }

    public static a E(@Nullable Activity activity) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (cgt.isEmpty()) {
            return bP(bO(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + cgt.getFirst());
        }
        a removeFirst = cgt.removeFirst();
        c cVar = removeFirst.cgw;
        if (cVar != null && activity != null) {
            cVar.attachActivity(activity);
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        al.c(new Runnable() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                b.bN(f.akr().akb());
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

    public static void a(a aVar, InterfaceC0353b interfaceC0353b) {
        if (interfaceC0353b != null) {
            if (aVar.isReady) {
                interfaceC0353b.onReady();
            } else {
                aVar.cgx.add(interfaceC0353b);
            }
        }
    }

    private static a bP(Context context) {
        final a aVar = new a();
        aVar.cgy = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.cgw = d.adw().a(context, new e() { // from class: com.baidu.swan.apps.core.slave.b.3
            @Override // com.baidu.swan.apps.core.e
            public void fH(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.cgw.UR() + " url: " + str);
                }
                a.this.cgz = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.cgx.isEmpty()) {
                    Iterator<InterfaceC0353b> it = a.this.cgx.iterator();
                    while (it.hasNext()) {
                        InterfaceC0353b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.cgx.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = cgu;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c km(@NonNull String str) {
        c cVar = cgu.get(str != null ? str : "");
        if (cVar != null) {
            cgu.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        cgt.clear();
        cgu.clear();
    }
}
