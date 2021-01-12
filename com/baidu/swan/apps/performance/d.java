package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes8.dex */
public class d implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: a */
    public void L(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo xC;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (xC = com.baidu.swan.pms.database.a.bci().xC(com.baidu.swan.apps.runtime.d.aIn().getAppId())) != null) {
            UbcFlowEvent pZ = hybridUbcFlow.pZ("naStart");
            xC.dm(pZ == null ? System.currentTimeMillis() : pZ.aDK());
            com.baidu.swan.pms.database.a.bci().s(xC);
        }
    }
}
