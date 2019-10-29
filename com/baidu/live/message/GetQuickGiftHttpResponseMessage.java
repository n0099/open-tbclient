package com.baidu.live.message;

import com.baidu.live.gift.l;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetQuickGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    private l aki;

    public GetQuickGiftHttpResponseMessage() {
        super(1021124);
    }

    public l ur() {
        return this.aki;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aki = new l();
            this.aki.parseJson(jSONObject);
        }
    }
}
