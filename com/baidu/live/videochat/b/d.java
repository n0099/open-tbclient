package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    public AlaLiveInfoData aIE;
    public AlaLiveUserInfoData aIl;
    public a brA;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aIl = new AlaLiveUserInfoData();
                this.aIl.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aIE = new AlaLiveInfoData();
                this.aIE.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.brA = new a();
                this.brA.parserJson(optJSONObject3);
            }
        }
    }
}
