package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bl {
    public JSONObject aRk;
    public JSONObject aRl;

    public bl(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aRk = jSONObject.optJSONObject("bubble_effect");
            this.aRl = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
