package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bg {
    public AlaLiveInfoData aQM;
    public bb aQN;
    public AlaLiveUserInfoData aQy;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aQy = new AlaLiveUserInfoData();
                this.aQy.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aQM = new AlaLiveInfoData();
                this.aQM.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aQN = new bb();
                this.aQN.parserJson(optJSONObject3);
            }
        }
    }
}
