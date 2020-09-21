package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ay {
    public AlaLiveUserInfoData aJI;
    public AlaLiveInfoData aJW;
    public at aJX;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aJI = new AlaLiveUserInfoData();
                this.aJI.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aJW = new AlaLiveInfoData();
                this.aJW.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aJX = new at();
                this.aJX.parserJson(optJSONObject3);
            }
        }
    }
}
