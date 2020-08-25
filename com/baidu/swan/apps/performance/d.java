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
        PMSAppInfo wz;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (wz = com.baidu.swan.pms.database.a.aTt().wz(com.baidu.swan.apps.runtime.d.azE().getAppId())) != null) {
            UbcFlowEvent pd = hybridUbcFlow.pd("naStart");
            wz.cf(pd == null ? System.currentTimeMillis() : pd.avW());
            com.baidu.swan.pms.database.a.aTt().s(wz);
        }
    }
}
