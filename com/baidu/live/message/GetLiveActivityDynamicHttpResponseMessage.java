package com.baidu.live.message;

import com.baidu.live.data.bi;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetLiveActivityDynamicHttpResponseMessage extends JsonHttpResponsedMessage {
    private bi bmR;

    public GetLiveActivityDynamicHttpResponseMessage() {
        super(1021126);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bmR = new bi();
            this.bmR.parserJson(jSONObject);
        }
    }
}
