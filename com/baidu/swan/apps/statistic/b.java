package com.baidu.swan.apps.statistic;

import android.util.Log;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.ubc.s;
/* loaded from: classes11.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void b(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar == null) {
            if (DEBUG) {
                Log.w("SwanAppFuncUbc", "event is null");
                return;
            }
            return;
        }
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mAppId = fVar.mAppId;
        eVar.mFrom = fVar.mFrom;
        eVar.mPage = fVar.mPage;
        eVar.mSource = fVar.mSource;
        eVar.mType = fVar.mType;
        eVar.mValue = fVar.mValue;
        eVar.bk(fVar.anj());
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.b.1
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("934", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppFuncClickUBC");
    }
}
