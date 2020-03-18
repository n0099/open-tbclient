package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aj {
    public JSONObject acF;
    public JSONObject acG;

    public aj(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.acF = jSONObject.optJSONObject("bubble_effect");
            this.acG = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
