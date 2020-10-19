package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetAudioLiveStatusHttpResponseMessage extends JsonHttpResponsedMessage {
    public String bld;
    public String ble;
    public String blf;
    public long liveId;

    public AlaGetAudioLiveStatusHttpResponseMessage() {
        super(1031043);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.liveId = optJSONObject.optLong("liveId");
            this.bld = optJSONObject.optString("queryType");
            this.ble = optJSONObject.optString("queryResult");
            this.blf = optJSONObject.optString("requestType");
        }
    }
}
