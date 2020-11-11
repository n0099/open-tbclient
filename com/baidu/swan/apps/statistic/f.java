package com.baidu.swan.apps.statistic;

import android.util.Log;
import com.baidu.swan.apps.ap.p;
/* loaded from: classes10.dex */
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
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.1
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
        com.baidu.swan.apps.statistic.a.d i2 = new com.baidu.swan.apps.statistic.a.d().ti(h.ky(i)).i(new com.baidu.swan.apps.am.a().cv(11L).cw(2331L).ua("Retry=" + z + ", Scene=" + dVar.getClass().getName()));
        if (dVar instanceof com.baidu.swan.apps.core.pms.g) {
            i2.a(((com.baidu.swan.apps.core.pms.g) dVar).aqA());
        }
        a(i2);
        if (DEBUG) {
            Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + dVar.getClass().getSimpleName());
        }
    }
}
