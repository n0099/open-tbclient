package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bk {
    public AlaLiveUserInfoData aOI;
    public AlaLiveInfoData aOW;
    public bf aOX;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aOI = new AlaLiveUserInfoData();
                this.aOI.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aOW = new AlaLiveInfoData();
                this.aOW.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aOX = new bf();
                this.aOX.parserJson(optJSONObject3);
            }
        }
    }
}
