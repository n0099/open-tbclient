package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ay {
    public AlaLiveUserInfoData aMN;
    public AlaLiveInfoData aNb;
    public at aNc;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aMN = new AlaLiveUserInfoData();
                this.aMN.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aNb = new AlaLiveInfoData();
                this.aNb.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aNc = new at();
                this.aNc.parserJson(optJSONObject3);
            }
        }
    }
}
