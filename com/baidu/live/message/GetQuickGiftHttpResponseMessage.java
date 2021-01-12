package com.baidu.live.message;

import com.baidu.live.gift.o;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetQuickGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    private o brC;

    public GetQuickGiftHttpResponseMessage() {
        super(1021124);
    }

    public o MY() {
        return this.brC;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.brC = new o();
            this.brC.parseJson(jSONObject);
        }
    }
}
