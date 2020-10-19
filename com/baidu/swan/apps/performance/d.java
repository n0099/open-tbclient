package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes10.dex */
public class d implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public void M(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo xF;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (xF = com.baidu.swan.pms.database.a.aWO().xF(com.baidu.swan.apps.runtime.d.aCW().getAppId())) != null) {
            UbcFlowEvent qj = hybridUbcFlow.qj("naStart");
            xF.co(qj == null ? System.currentTimeMillis() : qj.azq());
            com.baidu.swan.pms.database.a.aWO().s(xF);
        }
    }
}
