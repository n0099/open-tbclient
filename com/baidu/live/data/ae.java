package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ae {
    public AlaLiveInfoData abJ;
    public ac abK;
    public AlaLiveUserInfoData abx;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.abx = new AlaLiveUserInfoData();
                this.abx.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.abJ = new AlaLiveInfoData();
                this.abJ.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.abK = new ac();
                this.abK.parserJson(optJSONObject3);
            }
        }
    }
}
