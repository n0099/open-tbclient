package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes7.dex */
public class d implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public void M(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo yh;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (yh = com.baidu.swan.pms.database.a.baA().yh(com.baidu.swan.apps.runtime.d.aGI().getAppId())) != null) {
            UbcFlowEvent qK = hybridUbcFlow.qK("naStart");
            yh.cM(qK == null ? System.currentTimeMillis() : qK.aDc());
            com.baidu.swan.pms.database.a.baA().s(yh);
        }
    }
}
