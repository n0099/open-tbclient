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
/* loaded from: classes3.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> coO = new LinkedList<>();
    private static Map<String, c> coP = new TreeMap();

    /* loaded from: classes3.dex */
    public static class a {
        public c coR;
        public final ArrayList<InterfaceC0390b> coS = new ArrayList<>();
        public long coT;
        public long coU;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0390b {
        void onReady();
    }

    public static void bT(Context context) {
        if (coO.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            coO.add(bV(bU(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + coO.size());
        }
    }

    private static Context bU(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.t.a.apu();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.t.a.apu();
        }
        return context;
    }

    public static a f(@Nullable Activity activity, boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (coO.isEmpty()) {
            return bV(bU(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + coO.getFirst());
        }
        a removeFirst = coO.removeFirst();
        c cVar = removeFirst.coR;
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
                    b.bT(f.asJ().ast());
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

    public static void a(a aVar, InterfaceC0390b interfaceC0390b) {
        if (interfaceC0390b != null) {
            if (aVar.isReady) {
                interfaceC0390b.onReady();
            } else {
                aVar.coS.add(interfaceC0390b);
            }
        }
    }

    private static a bV(Context context) {
        final a aVar = new a();
        aVar.coT = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.coR = d.akC().a(context, new g() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // com.baidu.swan.apps.core.g
            public void hp(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.coR.abD() + " url: " + str);
                }
                a.this.coU = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.coS.isEmpty()) {
                    Iterator<InterfaceC0390b> it = a.this.coS.iterator();
                    while (it.hasNext()) {
                        InterfaceC0390b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.coS.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = coP;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c mj(@NonNull String str) {
        c cVar = coP.get(str != null ? str : "");
        if (cVar != null) {
            coP.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        coO.clear();
        coP.clear();
    }
}
