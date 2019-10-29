package com.baidu.live.message;

import com.baidu.live.data.i;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGetLiveInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private i aaB;

    public AlaGetLiveInfoHttpResponseMessage() {
        super(1021007);
    }

    public i uj() {
        return this.aaB;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && getError() == 0) {
            this.aaB = new i();
            this.aaB.parserJson(optJSONObject);
        }
    }
}
