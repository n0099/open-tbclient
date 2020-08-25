package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ay {
    public JSONObject aJc;
    public JSONObject aJd;

    public ay(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJc = jSONObject.optJSONObject("bubble_effect");
            this.aJd = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
