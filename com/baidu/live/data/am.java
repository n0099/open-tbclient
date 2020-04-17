package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class am {
    public JSONObject auY;
    public JSONObject auZ;

    public am(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.auY = jSONObject.optJSONObject("bubble_effect");
            this.auZ = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
