package com.baidu.live.message;

import com.baidu.live.data.ad;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetLiveActivityDynamicHttpResponseMessage extends JsonHttpResponsedMessage {
    private ad ajO;

    public GetLiveActivityDynamicHttpResponseMessage() {
        super(1021126);
    }

    public ad uq() {
        return this.ajO;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.ajO = new ad();
            this.ajO.parserJson(jSONObject);
        }
    }
}
