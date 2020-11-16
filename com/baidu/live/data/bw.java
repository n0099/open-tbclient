package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bw {
    public int aOH = 7;
    public int aOI;
    public String aOJ;
    public String aOK;

    public bw(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOH = jSONObject.optInt("show_days");
            this.aOI = jSONObject.optInt("live_recommend_switch");
            this.aOJ = jSONObject.optString("live_recommend_enter_text");
            this.aOK = jSONObject.optString("live_recommend_text");
        }
    }
}
