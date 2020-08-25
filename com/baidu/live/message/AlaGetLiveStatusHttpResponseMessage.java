package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGetLiveStatusHttpResponseMessage extends JsonHttpResponsedMessage {
    public String bex;
    public String bey;
    public String bez;
    public long liveId;

    public AlaGetLiveStatusHttpResponseMessage() {
        super(1021050);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.liveId = optJSONObject.optLong("liveId");
            this.bex = optJSONObject.optString("queryType");
            this.bey = optJSONObject.optString("queryResult");
            this.bez = optJSONObject.optString("requestType");
        }
    }
}
