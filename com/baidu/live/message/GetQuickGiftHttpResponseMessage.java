package com.baidu.live.message;

import com.baidu.live.gift.o;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetQuickGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    private o bwF;

    public GetQuickGiftHttpResponseMessage() {
        super(1021124);
    }

    public o Oz() {
        return this.bwF;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bwF = new o();
            this.bwF.parseJson(jSONObject);
        }
    }
}
