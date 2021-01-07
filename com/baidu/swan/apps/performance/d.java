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
        PMSAppInfo yN;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (yN = com.baidu.swan.pms.database.a.bgc().yN(com.baidu.swan.apps.runtime.d.aMh().getAppId())) != null) {
            UbcFlowEvent rk = hybridUbcFlow.rk("naStart");
            yN.dm(rk == null ? System.currentTimeMillis() : rk.aHE());
            com.baidu.swan.pms.database.a.bgc().s(yN);
        }
    }
}
