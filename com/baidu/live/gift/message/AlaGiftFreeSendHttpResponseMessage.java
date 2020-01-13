package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGiftFreeSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long alJ;

    public AlaGiftFreeSendHttpResponseMessage() {
        super(1021014);
        this.alJ = 0L;
    }

    public long tr() {
        return this.alJ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021014) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.alJ = jSONObject.optLong("left_petal");
        }
    }
}
