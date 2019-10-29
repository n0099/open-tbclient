package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ab {
    public JSONObject TO;
    public JSONObject TP;

    public ab(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.TO = jSONObject.optJSONObject("bubble_effect");
            this.TP = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
