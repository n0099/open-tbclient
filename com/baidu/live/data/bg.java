package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bg {
    public AlaLiveUserInfoData aLL;
    public AlaLiveInfoData aLZ;
    public bb aMa;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aLL = new AlaLiveUserInfoData();
                this.aLL.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aLZ = new AlaLiveInfoData();
                this.aLZ.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aMa = new bb();
                this.aMa.parserJson(optJSONObject3);
            }
        }
    }
}
