package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ah {
    public AlaLiveUserInfoData auk;
    public AlaLiveInfoData auw;
    public af aux;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.auk = new AlaLiveUserInfoData();
                this.auk.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.auw = new AlaLiveInfoData();
                this.auw.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank_info");
            if (optJSONObject3 != null) {
                this.aux = new af();
                this.aux.parserJson(optJSONObject3);
            }
        }
    }
}
