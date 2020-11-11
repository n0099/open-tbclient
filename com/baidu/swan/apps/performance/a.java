package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public void M(HybridUbcFlow hybridUbcFlow) {
        if (DEBUG) {
            Log.i("FlowJarToH5Reporter", "report: flow=" + hybridUbcFlow);
        }
        if (com.baidu.swan.apps.v.f.azO().azQ()) {
            if (DEBUG || com.baidu.swan.apps.v.f.azO().azs()) {
                try {
                    k.aDJ().bv(c(hybridUbcFlow));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private JSONObject c(HybridUbcFlow hybridUbcFlow) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (hybridUbcFlow != null && !hybridUbcFlow.diN.isEmpty()) {
            jSONObject.put("flowId", hybridUbcFlow.aDj());
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.diN) {
                if (!ubcFlowEvent.aDM() && !TextUtils.isEmpty(ubcFlowEvent.id)) {
                    if (DEBUG) {
                        Log.i("FlowJarToH5Reporter", "buildJoMsg: event=" + ubcFlowEvent);
                    }
                    jSONArray.put(new JSONObject().put("actionId", ubcFlowEvent.id).put("timestamp", ubcFlowEvent.aDK()));
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
