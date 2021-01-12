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
    private static LinkedList<a> cUL = new LinkedList<>();
    private static Map<String, c> cUM = new TreeMap();

    /* loaded from: classes8.dex */
    public static class a {
        public c cUO;
        public final ArrayList<InterfaceC0418b> cUP = new ArrayList<>();
        public long cUQ;
        public long cUR;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0418b {
        void onReady();
    }

    public static void cM(Context context) {
        if (cUL.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            cUL.add(cO(cN(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + cUL.size());
        }
    }

    private static Context cN(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.t.a.awy();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.t.a.awy();
        }
        return context;
    }

    public static a f(@Nullable Activity activity, boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (cUL.isEmpty()) {
            return cO(cN(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + cUL.getFirst());
        }
        a removeFirst = cUL.removeFirst();
        c cVar = removeFirst.cUO;
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
                    b.cM(f.azN().azx());
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

    public static void a(a aVar, InterfaceC0418b interfaceC0418b) {
        if (interfaceC0418b != null) {
            if (aVar.isReady) {
                interfaceC0418b.onReady();
            } else {
                aVar.cUP.add(interfaceC0418b);
            }
        }
    }

    private static a cO(Context context) {
        final a aVar = new a();
        aVar.cUQ = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.cUO = d.arG().a(context, new g() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // com.baidu.swan.apps.core.g
            public void gV(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.cUO.aiA() + " url: " + str);
                }
                a.this.cUR = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.cUP.isEmpty()) {
                    Iterator<InterfaceC0418b> it = a.this.cUP.iterator();
                    while (it.hasNext()) {
                        InterfaceC0418b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.cUP.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = cUM;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c mM(@NonNull String str) {
        c cVar = cUM.get(str != null ? str : "");
        if (cVar != null) {
            cUM.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        cUL.clear();
        cUM.clear();
    }
}
