package com.baidu.live.message;

import com.baidu.live.data.bf;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetLiveActivityDynamicHttpResponseMessage extends JsonHttpResponsedMessage {
    private bf blv;

    public GetLiveActivityDynamicHttpResponseMessage() {
        super(1021126);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.blv = new bf();
            this.blv.parserJson(jSONObject);
        }
    }
}
