package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bv {
    public int aPv = 7;
    public int aPw;
    public String aPx;
    public String aPy;

    public bv(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPv = jSONObject.optInt("show_days");
            this.aPw = jSONObject.optInt("live_recommend_switch");
            this.aPx = jSONObject.optString("live_recommend_enter_text");
            this.aPy = jSONObject.optString("live_recommend_text");
        }
    }
}
