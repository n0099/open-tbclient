package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class av {
    public JSONObject aCx;
    public JSONObject aCy;

    public av(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aCx = jSONObject.optJSONObject("bubble_effect");
            this.aCy = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
