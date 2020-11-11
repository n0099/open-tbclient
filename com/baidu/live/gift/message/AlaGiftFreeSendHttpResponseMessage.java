package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGiftFreeSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bdV;

    public AlaGiftFreeSendHttpResponseMessage() {
        super(1021014);
        this.bdV = 0L;
    }

    public long Js() {
        return this.bdV;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021014) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bdV = jSONObject.optLong("left_petal");
        }
    }
}
