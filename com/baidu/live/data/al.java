package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class al {
    public AlaLiveInfoData azA;
    public aj azB;
    public AlaLiveUserInfoData azo;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.azo = new AlaLiveUserInfoData();
                this.azo.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.azA = new AlaLiveInfoData();
                this.azA.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.azB = new aj();
                this.azB.parserJson(optJSONObject3);
            }
        }
    }
}
