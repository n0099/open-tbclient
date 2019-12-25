package com.baidu.live.message;

import com.baidu.live.gift.n;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetQuickGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    private n arO;

    public GetQuickGiftHttpResponseMessage() {
        super(1021124);
    }

    public n wn() {
        return this.arO;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.arO = new n();
            this.arO.parseJson(jSONObject);
        }
    }
}
