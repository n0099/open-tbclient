package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bq {
    public JSONObject aPv;
    public JSONObject aPw;

    public bq(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPv = jSONObject.optJSONObject("bubble_effect");
            this.aPw = jSONObject.optJSONObject("nickname_effect");
        }
    }
}
