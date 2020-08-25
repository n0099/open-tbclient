package com.baidu.live.message;

import com.baidu.live.gift.o;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetQuickGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    private o beR;

    public GetQuickGiftHttpResponseMessage() {
        super(1021124);
    }

    public o LK() {
        return this.beR;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.beR = new o();
            this.beR.parseJson(jSONObject);
        }
    }
}
