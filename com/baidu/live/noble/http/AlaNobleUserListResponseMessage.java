package com.baidu.live.noble.http;

import com.baidu.live.noble.data.b;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaNobleUserListResponseMessage extends JsonHttpResponsedMessage {
    private b bxk;

    public AlaNobleUserListResponseMessage() {
        super(1021190);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && getError() == 0) {
            this.bxk = new b();
            this.bxk.parserJson(optJSONObject);
        }
    }

    public b Rn() {
        return this.bxk;
    }
}
