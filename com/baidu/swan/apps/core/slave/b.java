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
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LinkedList<a> cNI = new LinkedList<>();
    private static Map<String, c> cNJ = new TreeMap();

    /* loaded from: classes7.dex */
    public static class a {
        public c cNL;
        public final ArrayList<InterfaceC0431b> cNM = new ArrayList<>();
        public long cNN;
        public long cNO;
        public boolean isReady;
    }

    /* renamed from: com.baidu.swan.apps.core.slave.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0431b {
        void onReady();
    }

    public static void bZ(Context context) {
        if (cNI.size() < 2) {
            if (DEBUG) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            cNI.add(cb(ca(context)));
        } else if (DEBUG) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + cNI.size());
        }
    }

    private static Context ca(Context context) {
        if (context == null) {
            return com.baidu.swan.apps.t.a.avS();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return com.baidu.swan.apps.t.a.avS();
        }
        return context;
    }

    public static a f(@Nullable Activity activity, boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (cNI.isEmpty()) {
            return cb(ca(activity));
        }
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + cNI.getFirst());
        }
        a removeFirst = cNI.removeFirst();
        c cVar = removeFirst.cNL;
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
                    b.bZ(f.azg().ayQ());
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

    public static void a(a aVar, InterfaceC0431b interfaceC0431b) {
        if (interfaceC0431b != null) {
            if (aVar.isReady) {
                interfaceC0431b.onReady();
            } else {
                aVar.cNM.add(interfaceC0431b);
            }
        }
    }

    private static a cb(Context context) {
        final a aVar = new a();
        aVar.cNN = System.currentTimeMillis();
        aVar.isReady = false;
        aVar.cNL = d.ara().a(context, new g() { // from class: com.baidu.swan.apps.core.slave.b.2
            @Override // com.baidu.swan.apps.core.g
            public void hP(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + a.this.cNL.aib() + " url: " + str);
                }
                a.this.cNO = System.currentTimeMillis();
                a.this.isReady = true;
                if (!a.this.cNM.isEmpty()) {
                    Iterator<InterfaceC0431b> it = a.this.cNM.iterator();
                    while (it.hasNext()) {
                        InterfaceC0431b next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    a.this.cNM.clear();
                }
            }
        });
        return aVar;
    }

    public static void a(@NonNull String str, c cVar) {
        Map<String, c> map = cNJ;
        if (str == null) {
            str = "";
        }
        map.put(str, cVar);
    }

    public static c nx(@NonNull String str) {
        c cVar = cNJ.get(str != null ? str : "");
        if (cVar != null) {
            cNJ.remove(str);
        }
        return cVar;
    }

    public static void clearAll() {
        cNI.clear();
        cNJ.clear();
    }
}
