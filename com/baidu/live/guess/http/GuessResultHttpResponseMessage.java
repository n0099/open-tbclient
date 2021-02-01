package com.baidu.live.guess.http;

import com.baidu.live.data.o;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GuessResultHttpResponseMessage extends JsonHttpResponsedMessage {
    private o bjR;

    public GuessResultHttpResponseMessage() {
        super(1021239);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            if (this.bjR == null) {
                this.bjR = new o();
            }
            this.bjR.parserJson(optJSONObject);
        }
    }

    public o Jn() {
        return this.bjR;
    }
}
