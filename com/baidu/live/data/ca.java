package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ca {
    public String aSA;
    public String aSB;
    public int aSy = 7;
    public int aSz;
    public int showStyle;

    public ca(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSy = jSONObject.optInt("show_days");
            this.aSz = jSONObject.optInt("live_recommend_switch");
            this.aSA = jSONObject.optString("live_recommend_enter_text");
            this.aSB = jSONObject.optString("live_recommend_text");
            this.showStyle = jSONObject.optInt("show_style");
        }
    }
}
