package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public AlaLiveUserInfoData aQi;
    public AlaLiveInfoData aQw;
    public a bQE;

    public void parserJson(JSONObject jSONObject) {
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
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bQE = new a();
                this.bQE.parserJson(optJSONObject3);
            }
        }
    }
}
