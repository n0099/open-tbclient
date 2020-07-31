package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ar {
    public AlaLiveUserInfoData aDb;
    public AlaLiveInfoData aDu;
    public am aDv;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aDb = new AlaLiveUserInfoData();
                this.aDb.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aDu = new AlaLiveInfoData();
                this.aDu.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aDv = new am();
                this.aDv.parserJson(optJSONObject3);
            }
        }
    }
}
