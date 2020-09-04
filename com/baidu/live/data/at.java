package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class at {
    public AlaLiveInfoData aIG;
    public ao aIH;
    public AlaLiveUserInfoData aIn;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aIn = new AlaLiveUserInfoData();
                this.aIn.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aIG = new AlaLiveInfoData();
                this.aIG.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aIH = new ao();
                this.aIH.parserJson(optJSONObject3);
            }
        }
    }
}
