package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bd {
    public JSONObject aNA;
    public JSONObject aNz;

    public bd(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNz = jSONObject.optJSONObject("bubble_effect");
            this.aNA = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
