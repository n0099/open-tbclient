package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.as.d.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.as.d.b
    /* renamed from: a */
    public void D(HybridUbcFlow hybridUbcFlow) {
        if (DEBUG) {
            Log.i("FlowJarToH5Reporter", "report: flow=" + hybridUbcFlow);
        }
        com.baidu.swan.apps.y.f WV = com.baidu.swan.apps.y.f.WV();
        if (WV.WW()) {
            if (DEBUG || com.baidu.swan.apps.y.f.WV().WA()) {
                HashMap hashMap = new HashMap();
                try {
                    hashMap.put("flow", b(hybridUbcFlow).toString());
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                WV.a(new com.baidu.swan.apps.n.a.b("collect_performance", hashMap));
            }
        }
    }

    private JSONObject b(HybridUbcFlow hybridUbcFlow) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (hybridUbcFlow != null && !hybridUbcFlow.bHH.isEmpty()) {
            jSONObject.put("flowId", hybridUbcFlow.ZB());
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.bHH) {
                if (!ubcFlowEvent.aab() && !TextUtils.isEmpty(ubcFlowEvent.id)) {
                    if (DEBUG) {
                        Log.i("FlowJarToH5Reporter", "buildJoMsg: event=" + ubcFlowEvent);
                    }
                    jSONArray.put(new JSONObject().put("actionId", ubcFlowEvent.id).put("timestamp", ubcFlowEvent.ZZ()));
                }
            }
            jSONObject.put("data", jSONArray);
        }
        if (DEBUG) {
            Log.i("FlowJarToH5Reporter", "buildJoMsg: joMsg=" + jSONObject);
        }
        return jSONObject;
    }
}
