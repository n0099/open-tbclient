package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public AlaLiveUserInfoData aOI;
    public AlaLiveInfoData aOW;
    public a bPe;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aOI = new AlaLiveUserInfoData();
                this.aOI.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aOW = new AlaLiveInfoData();
                this.aOW.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bPe = new a();
                this.bPe.parserJson(optJSONObject3);
            }
        }
    }
}
