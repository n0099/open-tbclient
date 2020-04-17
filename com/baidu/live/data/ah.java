package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ah {
    public AlaLiveUserInfoData aue;
    public AlaLiveInfoData auq;
    public af aur;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aue = new AlaLiveUserInfoData();
                this.aue.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.auq = new AlaLiveInfoData();
                this.auq.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aur = new af();
                this.aur.parserJson(optJSONObject3);
            }
        }
    }
}
