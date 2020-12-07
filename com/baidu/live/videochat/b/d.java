package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public AlaLiveUserInfoData aPJ;
    public AlaLiveInfoData aPX;
    public a bLt;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aPJ = new AlaLiveUserInfoData();
                this.aPJ.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.aPX = new AlaLiveInfoData();
                this.aPX.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bLt = new a();
                this.bLt.parserJson(optJSONObject3);
            }
        }
    }
}
