package com.baidu.live.noble.http;

import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class NobleUserInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private NobleUserInfo bfW;

    public NobleUserInfoHttpResponseMessage() {
        super(1021195);
    }

    public NobleUserInfo LV() {
        return this.bfW;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bfW = new NobleUserInfo();
            this.bfW.parserJson(optJSONObject);
        }
    }
}
