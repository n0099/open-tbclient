package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bg {
    public JSONObject aOe;
    public JSONObject aOf;

    public bg(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOe = jSONObject.optJSONObject("bubble_effect");
            this.aOf = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
