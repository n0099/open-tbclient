package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bl {
    public JSONObject aMx;
    public JSONObject aMy;

    public bl(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aMx = jSONObject.optJSONObject("bubble_effect");
            this.aMy = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
