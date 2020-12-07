package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.util.AdExtParam;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetLiveStatusHttpResponseMessage extends JsonHttpResponsedMessage {
    public String bro;
    public String brp;
    public String brq;
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
            this.bro = optJSONObject.optString("queryType");
            this.brp = optJSONObject.optString("queryResult");
            this.brq = optJSONObject.optString(AdExtParam.KEY_REQUEST_TYPE);
        }
    }
}
