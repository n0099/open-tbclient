package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes7.dex */
public class d implements com.baidu.swan.apps.aq.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.aq.e.b
    /* renamed from: b */
    public void H(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo uq;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (uq = com.baidu.swan.pms.database.a.aKS().uq(com.baidu.swan.apps.runtime.d.arr().getAppId())) != null) {
            UbcFlowEvent nf = hybridUbcFlow.nf("naStart");
            uq.bZ(nf == null ? System.currentTimeMillis() : nf.aob());
            com.baidu.swan.pms.database.a.aKS().s(uq);
        }
    }
}
