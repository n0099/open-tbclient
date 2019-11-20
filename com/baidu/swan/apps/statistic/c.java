package com.baidu.swan.apps.statistic;

import android.util.Log;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.ubc.s;
/* loaded from: classes2.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(final com.baidu.swan.apps.statistic.a.d dVar) {
        if (dVar == null) {
            if (DEBUG) {
                Log.d("SwanStabilityUbc", "event is null");
                return;
            }
            return;
        }
        j.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.1
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
            }
        }, "SwanStabilityUBC");
    }

    public static void a(com.baidu.swan.pms.a.b bVar, int i, boolean z) {
        if (bVar == null) {
            if (DEBUG) {
                Log.d("SwanStabilityUbc", "pms callback is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.v.b.c cVar = null;
        if (bVar instanceof com.baidu.swan.apps.core.pms.c) {
            cVar = ((com.baidu.swan.apps.core.pms.c) bVar).Gm();
        } else if (bVar instanceof com.baidu.swan.apps.core.pms.e) {
            cVar = ((com.baidu.swan.apps.core.pms.e) bVar).Gm();
        }
        a(new com.baidu.swan.apps.statistic.a.d().ia(e.eL(i)).a(new com.baidu.swan.apps.ak.a().ar(11L).as(2331L).iL("Retry=" + z + ", Scene=" + bVar.getClass().getName())).c(cVar));
        if (DEBUG) {
            Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + bVar.getClass().getSimpleName());
        }
    }
}
