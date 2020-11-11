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
        PMSAppInfo ym;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (ym = com.baidu.swan.pms.database.a.bbh().ym(com.baidu.swan.apps.runtime.d.aHq().getAppId())) != null) {
            UbcFlowEvent qQ = hybridUbcFlow.qQ("naStart");
            ym.cM(qQ == null ? System.currentTimeMillis() : qQ.aDK());
            com.baidu.swan.pms.database.a.bbh().s(ym);
        }
    }
}
