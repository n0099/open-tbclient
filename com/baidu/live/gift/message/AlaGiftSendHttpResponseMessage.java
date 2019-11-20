package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long acZ;
    private long ada;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.acZ = 0L;
    }

    public long rn() {
        return this.acZ;
    }

    public long ro() {
        return this.ada;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.acZ = jSONObject.optLong("left_scores");
            this.ada = jSONObject.optLong("tdou_num");
        }
    }
}
