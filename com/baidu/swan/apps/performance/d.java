package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes8.dex */
public class d implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public void I(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo wA;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (wA = com.baidu.swan.pms.database.a.aTt().wA(com.baidu.swan.apps.runtime.d.azE().getAppId())) != null) {
            UbcFlowEvent pe = hybridUbcFlow.pe("naStart");
            wA.cf(pe == null ? System.currentTimeMillis() : pe.avW());
            com.baidu.swan.pms.database.a.aTt().s(wA);
        }
    }
}
