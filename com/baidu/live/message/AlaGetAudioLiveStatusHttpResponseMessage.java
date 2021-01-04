package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.util.AdExtParam;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetAudioLiveStatusHttpResponseMessage extends JsonHttpResponsedMessage {
    public String bvV;
    public String bvW;
    public String bvX;
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
            this.bvV = optJSONObject.optString("queryType");
            this.bvW = optJSONObject.optString("queryResult");
            this.bvX = optJSONObject.optString(AdExtParam.KEY_REQUEST_TYPE);
        }
    }
}
