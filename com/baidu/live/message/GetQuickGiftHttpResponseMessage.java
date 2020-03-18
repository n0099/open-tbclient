package com.baidu.live.message;

import com.baidu.live.gift.o;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetQuickGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    private o awW;

    public GetQuickGiftHttpResponseMessage() {
        super(1021124);
    }

    public o zb() {
        return this.awW;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.awW = new o();
            this.awW.parseJson(jSONObject);
        }
    }
}
