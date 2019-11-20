package com.baidu.live.message;

import com.baidu.live.gift.l;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetQuickGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    private l ajQ;

    public GetQuickGiftHttpResponseMessage() {
        super(1021124);
    }

    public l us() {
        return this.ajQ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.ajQ = new l();
            this.ajQ.parseJson(jSONObject);
        }
    }
}
