package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ch {
    public int aQM = 7;
    public int aQN;
    public String aQO;
    public String aQP;
    public int showStyle;

    public ch(JSONObject jSONObject) {
        parseData(jSONObject);
    }

    private void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQM = jSONObject.optInt("show_days");
            this.aQN = jSONObject.optInt("live_recommend_switch");
            this.aQO = jSONObject.optString("live_recommend_enter_text");
            this.aQP = jSONObject.optString("live_recommend_text");
            this.showStyle = jSONObject.optInt("show_style");
        }
    }
}
