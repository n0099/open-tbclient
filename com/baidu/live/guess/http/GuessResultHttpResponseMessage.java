package com.baidu.live.guess.http;

import com.baidu.live.data.o;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GuessResultHttpResponseMessage extends JsonHttpResponsedMessage {
    private o blr;

    public GuessResultHttpResponseMessage() {
        super(1021239);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            if (this.blr == null) {
                this.blr = new o();
            }
            this.blr.parserJson(optJSONObject);
        }
    }

    public o Jq() {
        return this.blr;
    }
}
