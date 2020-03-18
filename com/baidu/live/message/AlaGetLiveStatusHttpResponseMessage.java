package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetLiveStatusHttpResponseMessage extends JsonHttpResponsedMessage {
    public String awE;
    public String awF;
    public String awG;
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
            this.awE = optJSONObject.optString("queryType");
            this.awF = optJSONObject.optString("queryResult");
            this.awG = optJSONObject.optString("requestType");
        }
    }
}
