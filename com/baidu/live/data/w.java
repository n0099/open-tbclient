package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class w {
    public AlaLiveUserInfoData SF;
    public AlaLiveInfoData SG;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.SF = new AlaLiveUserInfoData();
                this.SF.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.SG = new AlaLiveInfoData();
                this.SG.parserJson(optJSONObject2);
            }
        }
    }
}
