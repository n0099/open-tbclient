package com.baidu.live.yuyinnoble.http;

import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class NobleUserInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private NobleUserInfo bxE;

    public NobleUserInfoHttpResponseMessage() {
        super(1031068);
    }

    public NobleUserInfo Ro() {
        return this.bxE;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bxE = new NobleUserInfo();
            this.bxE.parserJson(optJSONObject);
        }
    }
}
