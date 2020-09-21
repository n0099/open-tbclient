package com.baidu.live.noble.http;

import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NobleUserInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private NobleUserInfo biQ;

    public NobleUserInfoHttpResponseMessage() {
        super(1021195);
    }

    public NobleUserInfo My() {
        return this.biQ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.biQ = new NobleUserInfo();
            this.biQ.parserJson(optJSONObject);
        }
    }
}
