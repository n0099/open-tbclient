package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ay {
    public JSONObject aJe;
    public JSONObject aJf;

    public ay(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJe = jSONObject.optJSONObject("bubble_effect");
            this.aJf = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
