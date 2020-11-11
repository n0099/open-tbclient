package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bi {
    public JSONObject aPh;
    public JSONObject aPi;

    public bi(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPh = jSONObject.optJSONObject("bubble_effect");
            this.aPi = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
