package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ar {
    public JSONObject aAm;
    public JSONObject aAn;

    public ar(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAm = jSONObject.optJSONObject("bubble_effect");
            this.aAn = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
