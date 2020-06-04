package com.baidu.swan.apps.statistic;

import android.util.Log;
import com.baidu.swan.apps.aq.n;
/* loaded from: classes11.dex */
public final class f {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(final com.baidu.swan.apps.statistic.a.d dVar) {
        if (dVar == null) {
            if (DEBUG) {
                Log.d("SwanStabilityUbc", "event is null");
                return;
            }
            return;
        }
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.ubc.e.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
            }
        }, "SwanStabilityUBC");
    }

    public static void a(com.baidu.swan.pms.a.d dVar, int i, boolean z) {
        if (dVar == null) {
            if (DEBUG) {
                Log.d("SwanStabilityUbc", "pms callback is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d f = new com.baidu.swan.apps.statistic.a.d().oC(h.gU(i)).f(new com.baidu.swan.apps.an.a().bw(11L).bx(2331L).pt("Retry=" + z + ", Scene=" + dVar.getClass().getName()));
        if (dVar instanceof com.baidu.swan.apps.core.pms.g) {
            f.a(((com.baidu.swan.apps.core.pms.g) dVar).aad());
        }
        a(f);
        if (DEBUG) {
            Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + dVar.getClass().getSimpleName());
        }
    }
}
