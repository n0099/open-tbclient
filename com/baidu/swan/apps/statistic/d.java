package com.baidu.swan.apps.statistic;

import android.util.Log;
import com.baidu.swan.apps.ap.p;
/* loaded from: classes10.dex */
public final class d {
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
        eVar.ca(fVar.aHV());
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.d.1
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("934", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppFuncClickUBC");
    }
}
