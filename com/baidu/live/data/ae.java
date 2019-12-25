package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ae {
    public JSONObject aak;
    public JSONObject aal;

    public ae(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aak = jSONObject.optJSONObject("bubble_effect");
            this.aal = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
