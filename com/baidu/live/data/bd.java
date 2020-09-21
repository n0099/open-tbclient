package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bd {
    public JSONObject aKu;
    public JSONObject aKv;

    public bd(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKu = jSONObject.optJSONObject("bubble_effect");
            this.aKv = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
