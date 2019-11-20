package com.baidu.live.message;

import com.baidu.live.data.i;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGetLiveInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private i aaj;

    public AlaGetLiveInfoHttpResponseMessage() {
        super(1021007);
    }

    public i uk() {
        return this.aaj;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && getError() == 0) {
            this.aaj = new i();
            this.aaj.parserJson(optJSONObject);
        }
    }
}
