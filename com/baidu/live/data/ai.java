package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ai {
    public JSONObject aax;
    public JSONObject aay;

    public ai(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aax = jSONObject.optJSONObject("bubble_effect");
            this.aay = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
