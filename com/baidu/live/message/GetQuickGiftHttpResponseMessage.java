package com.baidu.live.message;

import com.baidu.live.gift.o;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetQuickGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    private o aQz;

    public GetQuickGiftHttpResponseMessage() {
        super(1021124);
    }

    public o DV() {
        return this.aQz;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aQz = new o();
            this.aQz.parseJson(jSONObject);
        }
    }
}
