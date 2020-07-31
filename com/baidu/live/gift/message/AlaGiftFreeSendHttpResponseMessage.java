package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGiftFreeSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long aQl;

    public AlaGiftFreeSendHttpResponseMessage() {
        super(1021014);
        this.aQl = 0L;
    }

    public long By() {
        return this.aQl;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021014) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aQl = jSONObject.optLong("left_petal");
        }
    }
}
