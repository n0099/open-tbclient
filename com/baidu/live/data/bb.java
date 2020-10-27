package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bb {
    public AlaLiveInfoData aNG;
    public aw aNH;
    public AlaLiveUserInfoData aNs;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aNs = new AlaLiveUserInfoData();
                this.aNs.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aNG = new AlaLiveInfoData();
                this.aNG.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aNH = new aw();
                this.aNH.parserJson(optJSONObject3);
            }
        }
    }
}
