package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bw {
    public int aQs = 7;
    public int aQt;
    public String aQu;
    public String aQv;

    public bw(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQs = jSONObject.optInt("show_days");
            this.aQt = jSONObject.optInt("live_recommend_switch");
            this.aQu = jSONObject.optString("live_recommend_enter_text");
            this.aQv = jSONObject.optString("live_recommend_text");
        }
    }
}
