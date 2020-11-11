package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bd {
    public AlaLiveInfoData aOJ;
    public ay aOK;
    public AlaLiveUserInfoData aOv;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aOv = new AlaLiveUserInfoData();
                this.aOv.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aOJ = new AlaLiveInfoData();
                this.aOJ.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aOK = new ay();
                this.aOK.parserJson(optJSONObject3);
            }
        }
    }
}
