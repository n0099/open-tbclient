package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class at {
    public AlaLiveInfoData aIE;
    public ao aIF;
    public AlaLiveUserInfoData aIl;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aIl = new AlaLiveUserInfoData();
                this.aIl.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aIE = new AlaLiveInfoData();
                this.aIE.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aIF = new ao();
                this.aIF.parserJson(optJSONObject3);
            }
        }
    }
}
