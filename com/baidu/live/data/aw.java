package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aw {
    public JSONObject aDS;
    public JSONObject aDT;

    public aw(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aDS = jSONObject.optJSONObject("bubble_effect");
            this.aDT = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
