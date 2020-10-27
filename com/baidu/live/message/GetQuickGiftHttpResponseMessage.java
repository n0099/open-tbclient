package com.baidu.live.message;

import com.baidu.live.gift.o;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetQuickGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    private o bmS;

    public GetQuickGiftHttpResponseMessage() {
        super(1021124);
    }

    public o NK() {
        return this.bmS;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bmS = new o();
            this.bmS.parseJson(jSONObject);
        }
    }
}
