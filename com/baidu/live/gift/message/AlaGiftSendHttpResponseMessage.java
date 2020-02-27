package com.baidu.live.gift.message;

import com.baidu.live.gift.a.a;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long anW;
    private long anX;
    private long anY;
    private a anZ;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.anW = 0L;
    }

    public long uJ() {
        return this.anW;
    }

    public long uK() {
        return this.anX;
    }

    public long uL() {
        return this.anY;
    }

    public a uM() {
        return this.anZ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.anW = jSONObject.optLong("left_scores");
            this.anX = jSONObject.optLong("tdou_num");
            this.anY = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.anZ = a.q(optJSONObject);
            }
        }
    }
}
