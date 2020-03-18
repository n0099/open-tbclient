package com.baidu.swan.apps.statistic;

import android.util.Log;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.ubc.s;
/* loaded from: classes11.dex */
public final class d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(final com.baidu.swan.apps.statistic.a.d dVar) {
        if (dVar == null) {
            if (DEBUG) {
                Log.d("SwanStabilityUbc", "event is null");
                return;
            }
            return;
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.d.1
            @Override // java.lang.Runnable
            public void run() {
                s.k("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
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
        com.baidu.swan.apps.statistic.a.d e = new com.baidu.swan.apps.statistic.a.d().lM(f.gs(i)).e(new com.baidu.swan.apps.ap.a().aI(11L).aJ(2331L).my("Retry=" + z + ", Scene=" + dVar.getClass().getName()));
        if (dVar instanceof com.baidu.swan.apps.core.pms.g) {
            e.a(((com.baidu.swan.apps.core.pms.g) dVar).PD());
        }
        a(e);
        if (DEBUG) {
            Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + dVar.getClass().getSimpleName());
        }
    }
}
