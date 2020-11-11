package com.baidu.live.message;

import com.baidu.live.gift.n;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetQuickGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    private n bol;

    public GetQuickGiftHttpResponseMessage() {
        super(1021124);
    }

    public n Ok() {
        return this.bol;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bol = new n();
            this.bol.parseJson(jSONObject);
        }
    }
}
