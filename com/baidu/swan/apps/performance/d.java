package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes8.dex */
public class d implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: a */
    public void N(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo yc;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (yc = com.baidu.swan.pms.database.a.bcx().yc(com.baidu.swan.apps.runtime.d.aIJ().getAppId())) != null) {
            UbcFlowEvent qy = hybridUbcFlow.qy("naStart");
            yc.ds(qy == null ? System.currentTimeMillis() : qy.aEi());
            com.baidu.swan.pms.database.a.bcx().s(yc);
        }
    }
}
