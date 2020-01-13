package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ad {
    public AlaLiveUserInfoData ZC;
    public AlaLiveInfoData ZO;
    public ab ZP;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.ZC = new AlaLiveUserInfoData();
                this.ZC.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.ZO = new AlaLiveInfoData();
                this.ZO.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.ZP = new ab();
                this.ZP.parserJson(optJSONObject3);
            }
        }
    }
}
