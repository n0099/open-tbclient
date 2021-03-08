package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bq {
    public JSONObject aQV;
    public JSONObject aQW;

    public bq(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQV = jSONObject.optJSONObject("bubble_effect");
            this.aQW = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
