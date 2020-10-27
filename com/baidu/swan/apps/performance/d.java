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
        PMSAppInfo xY;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (xY = com.baidu.swan.pms.database.a.aYH().xY(com.baidu.swan.apps.runtime.d.aEQ().getAppId())) != null) {
            UbcFlowEvent qC = hybridUbcFlow.qC("naStart");
            xY.cq(qC == null ? System.currentTimeMillis() : qC.aBk());
            com.baidu.swan.pms.database.a.aYH().s(xY);
        }
    }
}
