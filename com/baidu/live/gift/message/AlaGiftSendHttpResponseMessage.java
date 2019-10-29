package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long ads;
    private long adt;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.ads = 0L;
    }

    public long rm() {
        return this.ads;
    }

    public long rn() {
        return this.adt;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.ads = jSONObject.optLong("left_scores");
            this.adt = jSONObject.optLong("tdou_num");
        }
    }
}
