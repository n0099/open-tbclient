package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ch {
    public int aSm = 7;
    public int aSn;
    public String aSo;
    public String aSp;
    public int showStyle;

    public ch(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSm = jSONObject.optInt("show_days");
            this.aSn = jSONObject.optInt("live_recommend_switch");
            this.aSo = jSONObject.optString("live_recommend_enter_text");
            this.aSp = jSONObject.optString("live_recommend_text");
            this.showStyle = jSONObject.optInt("show_style");
        }
    }
}
