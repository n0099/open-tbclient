package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ab {
    public JSONObject Tt;
    public JSONObject Tu;

    public ab(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Tt = jSONObject.optJSONObject("bubble_effect");
            this.Tu = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
