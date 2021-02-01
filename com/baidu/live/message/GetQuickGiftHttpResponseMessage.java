package com.baidu.live.message;

import com.baidu.live.gift.o;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetQuickGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    private o bvf;

    public GetQuickGiftHttpResponseMessage() {
        super(1021124);
    }

    public o Ow() {
        return this.bvf;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bvf = new o();
            this.bvf.parseJson(jSONObject);
        }
    }
}
