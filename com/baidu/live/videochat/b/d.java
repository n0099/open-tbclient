package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public AlaLiveUserInfoData aBG;
    public AlaLiveInfoData aBZ;
    public a blA;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aBG = new AlaLiveUserInfoData();
                this.aBG.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aBZ = new AlaLiveInfoData();
                this.aBZ.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.blA = new a();
                this.blA.parserJson(optJSONObject3);
            }
        }
    }
}
