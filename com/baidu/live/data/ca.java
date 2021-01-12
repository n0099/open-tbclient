package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ca {
    public int aNL = 7;
    public int aNM;
    public String aNN;
    public String aNO;
    public int showStyle;

    public ca(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNL = jSONObject.optInt("show_days");
            this.aNM = jSONObject.optInt("live_recommend_switch");
            this.aNN = jSONObject.optString("live_recommend_enter_text");
            this.aNO = jSONObject.optString("live_recommend_text");
            this.showStyle = jSONObject.optInt("show_style");
        }
    }
}
