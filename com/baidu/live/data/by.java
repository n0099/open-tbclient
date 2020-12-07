package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class by {
    public int aRJ = 7;
    public int aRK;
    public String aRL;
    public String aRM;

    public by(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aRJ = jSONObject.optInt("show_days");
            this.aRK = jSONObject.optInt("live_recommend_switch");
            this.aRL = jSONObject.optString("live_recommend_enter_text");
            this.aRM = jSONObject.optString("live_recommend_text");
        }
    }
}
