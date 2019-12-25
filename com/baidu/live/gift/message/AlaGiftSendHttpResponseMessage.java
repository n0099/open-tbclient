package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long akX;
    private long akY;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.akX = 0L;
    }

    public long tb() {
        return this.akX;
    }

    public long tc() {
        return this.akY;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.akX = jSONObject.optLong("left_scores");
            this.akY = jSONObject.optLong("tdou_num");
        }
    }
}
