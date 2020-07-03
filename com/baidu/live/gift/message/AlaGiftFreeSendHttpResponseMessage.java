package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGiftFreeSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long aOS;

    public AlaGiftFreeSendHttpResponseMessage() {
        super(1021014);
        this.aOS = 0L;
    }

    public long AW() {
        return this.aOS;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021014) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aOS = jSONObject.optLong("left_petal");
        }
    }
}
