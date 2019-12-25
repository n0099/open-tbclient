package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class z {
    public AlaLiveUserInfoData ZA;
    public AlaLiveInfoData ZB;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.ZA = new AlaLiveUserInfoData();
                this.ZA.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.ZB = new AlaLiveInfoData();
                this.ZB.parserJson(optJSONObject2);
            }
        }
    }
}
