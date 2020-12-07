package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class be {
    public AlaLiveUserInfoData aPJ;
    public AlaLiveInfoData aPX;
    public az aPY;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aPJ = new AlaLiveUserInfoData();
                this.aPJ.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aPX = new AlaLiveInfoData();
                this.aPX.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aPY = new az();
                this.aPY.parserJson(optJSONObject3);
            }
        }
    }
}
