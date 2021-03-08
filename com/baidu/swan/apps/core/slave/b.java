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
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> cYy = new LinkedList<>();
    private static Map<String, c> cYz = new TreeMap();

    /* loaded from: classes8.dex */
    public static class a {
        public c cYB;
        public final ArrayList<InterfaceC0421b> cYC = new ArrayList<>();
        public long cYD;
        public long cYE;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0421b {
        void onReady();
    }

    public static void cK(Context context) {
        if (cYy.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            cYy.add(cM(cL(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + cYy.size());
        }
    }

    private static Context cL(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.t.a.awZ();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.t.a.awZ();
        }
        return context;
    }

    public static a f(@Nullable Activity activity, boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (cYy.isEmpty()) {
            return cM(cL(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + cYy.getFirst());
        }
        a removeFirst = cYy.removeFirst();
        c cVar = removeFirst.cYB;
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
                    b.cK(f.aAo().azY());
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

    public static void a(a aVar, InterfaceC0421b interfaceC0421b) {
        if (interfaceC0421b != null) {
            if (aVar.isReady) {
                interfaceC0421b.onReady();
            } else {
                aVar.cYC.add(interfaceC0421b);
            }
        }
    }

    private static a cM(Context context) {
        final a aVar = new a();
        aVar.cYD = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.cYB = d.ash().a(context, new g() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // com.baidu.swan.apps.core.g
            public void iA(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.cYB.ajb() + " url: " + str);
                }
                a.this.cYE = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.cYC.isEmpty()) {
                    Iterator<InterfaceC0421b> it = a.this.cYC.iterator();
                    while (it.hasNext()) {
                        InterfaceC0421b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.cYC.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = cYz;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c nl(@NonNull String str) {
        c cVar = cYz.get(str != null ? str : "");
        if (cVar != null) {
            cYz.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        cYy.clear();
        cYz.clear();
    }
}
