package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aq {
    public AlaLiveUserInfoData aBG;
    public AlaLiveInfoData aBZ;
    public al aCa;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aBG = new AlaLiveUserInfoData();
                this.aBG.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aBZ = new AlaLiveInfoData();
                this.aBZ.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aCa = new al();
                this.aCa.parserJson(optJSONObject3);
            }
        }
    }
}
