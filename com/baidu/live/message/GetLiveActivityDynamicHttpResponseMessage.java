package com.baidu.live.message;

import com.baidu.live.data.ay;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetLiveActivityDynamicHttpResponseMessage extends JsonHttpResponsedMessage {
    private ay aZv;

    public GetLiveActivityDynamicHttpResponseMessage() {
        super(1021126);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aZv = new ay();
            this.aZv.parserJson(jSONObject);
        }
    }
}
