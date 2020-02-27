package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aj {
    public JSONObject acu;
    public JSONObject acv;

    public aj(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.acu = jSONObject.optJSONObject("bubble_effect");
            this.acv = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
