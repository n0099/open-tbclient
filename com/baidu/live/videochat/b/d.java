package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public AlaLiveUserInfoData aLL;
    public AlaLiveInfoData aLZ;
    public a bLu;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aLL = new AlaLiveUserInfoData();
                this.aLL.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aLZ = new AlaLiveInfoData();
                this.aLZ.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bLu = new a();
                this.bLu.parserJson(optJSONObject3);
            }
        }
    }
}
