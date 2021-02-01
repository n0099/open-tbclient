package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes9.dex */
public class d implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: a */
    public void L(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo xV;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (xV = com.baidu.swan.pms.database.a.bcv().xV(com.baidu.swan.apps.runtime.d.aIG().getAppId())) != null) {
            UbcFlowEvent qr = hybridUbcFlow.qr("naStart");
            xV.ds(qr == null ? System.currentTimeMillis() : qr.aEf());
            com.baidu.swan.pms.database.a.bcv().s(xV);
        }
    }
}
