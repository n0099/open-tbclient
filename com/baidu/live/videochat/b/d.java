package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public AlaLiveInfoData aQM;
    public AlaLiveUserInfoData aQy;
    public a bQg;

    public void parserJson(JSONObject jSONObject) {
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
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bQg = new a();
                this.bQg.parserJson(optJSONObject3);
            }
        }
    }
}
