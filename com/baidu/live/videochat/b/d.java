package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    public AlaLiveInfoData aIG;
    public AlaLiveUserInfoData aIn;
    public a brD;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aIn = new AlaLiveUserInfoData();
                this.aIn.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aIG = new AlaLiveInfoData();
                this.aIG.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.brD = new a();
                this.brD.parserJson(optJSONObject3);
            }
        }
    }
}
