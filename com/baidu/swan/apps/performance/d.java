package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes25.dex */
public class d implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public void M(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo yO;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (yO = com.baidu.swan.pms.database.a.bdF().yO(com.baidu.swan.apps.runtime.d.aJQ().getAppId())) != null) {
            UbcFlowEvent rr = hybridUbcFlow.rr("naStart");
            yO.dl(rr == null ? System.currentTimeMillis() : rr.aGk());
            com.baidu.swan.pms.database.a.bdF().s(yO);
        }
    }
}
