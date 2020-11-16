package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bd {
    public AlaLiveUserInfoData aMK;
    public AlaLiveInfoData aMY;
    public ay aMZ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aMK = new AlaLiveUserInfoData();
                this.aMK.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aMY = new AlaLiveInfoData();
                this.aMY.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aMZ = new ay();
                this.aMZ.parserJson(optJSONObject3);
            }
        }
    }
}
