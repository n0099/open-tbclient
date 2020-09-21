package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes3.dex */
public class d implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public void J(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo wT;
        if (DEBUG) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null && (wT = com.baidu.swan.pms.database.a.aUf().wT(com.baidu.swan.apps.runtime.d.aAn().getAppId())) != null) {
            UbcFlowEvent px = hybridUbcFlow.px("naStart");
            wT.cg(px == null ? System.currentTimeMillis() : px.awF());
            com.baidu.swan.pms.database.a.aUf().s(wT);
        }
    }
}
