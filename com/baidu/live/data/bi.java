package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bi {
    public JSONObject aNw;
    public JSONObject aNx;

    public bi(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNw = jSONObject.optJSONObject("bubble_effect");
            this.aNx = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
