package com.baidu.swan.apps.statistic;

import android.util.Log;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.ubc.s;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar == null) {
            if (DEBUG) {
                Log.w("SwanAppFuncUbc", "event is null");
                return;
            }
            return;
        }
        j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.b.1
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("934", com.baidu.swan.apps.statistic.a.f.this.toJSONObject());
            }
        }, "SwanAppFuncClickUBC");
    }
}
