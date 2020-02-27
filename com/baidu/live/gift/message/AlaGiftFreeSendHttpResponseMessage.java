package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGiftFreeSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long anV;

    public AlaGiftFreeSendHttpResponseMessage() {
        super(1021014);
        this.anV = 0L;
    }

    public long uI() {
        return this.anV;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021014) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.anV = jSONObject.optLong("left_petal");
        }
    }
}
