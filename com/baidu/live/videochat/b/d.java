package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public AlaLiveInfoData azA;
    public AlaLiveUserInfoData azo;
    public a bgu;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.azo = new AlaLiveUserInfoData();
                this.azo.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.azA = new AlaLiveInfoData();
                this.azA.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bgu = new a();
                this.bgu.parserJson(optJSONObject3);
            }
        }
    }
}
