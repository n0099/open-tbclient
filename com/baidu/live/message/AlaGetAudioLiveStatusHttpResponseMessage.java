package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.util.AdExtParam;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetAudioLiveStatusHttpResponseMessage extends JsonHttpResponsedMessage {
    public String buK;
    public String buL;
    public String buM;
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
            this.buK = optJSONObject.optString("queryType");
            this.buL = optJSONObject.optString("queryResult");
            this.buM = optJSONObject.optString(AdExtParam.KEY_REQUEST_TYPE);
        }
    }
}
