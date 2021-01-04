package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaNobleUserListResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.noble.data.d bwd;

    public AlaNobleUserListResponseMessage() {
        super(1031032);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && getError() == 0) {
            this.bwd = new com.baidu.live.noble.data.d();
            this.bwd.parserJson(optJSONObject);
        }
    }

    public com.baidu.live.noble.data.d QN() {
        return this.bwd;
    }
}
