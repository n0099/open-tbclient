package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class w {
    public AlaLiveUserInfoData Tb;
    public AlaLiveInfoData Tc;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.Tb = new AlaLiveUserInfoData();
                this.Tb.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.Tc = new AlaLiveInfoData();
                this.Tc.parserJson(optJSONObject2);
            }
        }
    }
}
