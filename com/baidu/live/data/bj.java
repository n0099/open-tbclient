package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bj {
    public JSONObject aQv;
    public JSONObject aQw;

    public bj(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQv = jSONObject.optJSONObject("bubble_effect");
            this.aQw = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
