package com.baidu.swan.facade.requred.webview;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.baidu.swan.apps.adaptation.implementation.b {
    @Override // com.baidu.swan.apps.adaptation.implementation.b, com.baidu.swan.apps.adaptation.a.d
    public JSONObject getRawSwitch() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.d.a.bkf()) {
                jSONObject.put("swanswitch_android_setdata", 1);
            }
            jSONObject.put("swanswitch_ab_inline_video", 1);
            jSONObject.put("swanswitch_ab_inline_input", 1);
            jSONObject.put("swanswitch_ab_inline_textarea", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
