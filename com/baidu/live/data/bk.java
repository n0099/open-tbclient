package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bk {
    public AlaLiveUserInfoData aQi;
    public AlaLiveInfoData aQw;
    public bf aQx;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aQi = new AlaLiveUserInfoData();
                this.aQi.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aQw = new AlaLiveInfoData();
                this.aQw.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aQx = new bf();
                this.aQx.parserJson(optJSONObject3);
            }
        }
    }
}
