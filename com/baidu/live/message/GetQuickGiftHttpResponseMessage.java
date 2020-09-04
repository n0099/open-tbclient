package com.baidu.live.message;

import com.baidu.live.gift.o;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetQuickGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    private o beT;

    public GetQuickGiftHttpResponseMessage() {
        super(1021124);
    }

    public o LK() {
        return this.beT;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.beT = new o();
            this.beT.parseJson(jSONObject);
        }
    }
}
