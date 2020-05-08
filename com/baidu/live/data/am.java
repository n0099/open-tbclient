package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class am {
    public JSONObject ave;
    public JSONObject avf;

    public am(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ave = jSONObject.optJSONObject("bubble_effect");
            this.avf = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
