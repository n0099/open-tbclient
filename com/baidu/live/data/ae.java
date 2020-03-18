package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ae {
    public AlaLiveUserInfoData abH;
    public AlaLiveInfoData abT;
    public ac abU;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.abH = new AlaLiveUserInfoData();
                this.abH.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.abT = new AlaLiveInfoData();
                this.abT.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.abU = new ac();
                this.abU.parserJson(optJSONObject3);
            }
        }
    }
}
