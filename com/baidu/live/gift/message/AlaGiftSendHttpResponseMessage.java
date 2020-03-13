package com.baidu.live.gift.message;

import com.baidu.live.gift.a.a;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long anX;
    private long anY;
    private long anZ;
    private a aoa;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.anX = 0L;
    }

    public long uJ() {
        return this.anX;
    }

    public long uK() {
        return this.anY;
    }

    public long uL() {
        return this.anZ;
    }

    public a uM() {
        return this.aoa;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.anX = jSONObject.optLong("left_scores");
            this.anY = jSONObject.optLong("tdou_num");
            this.anZ = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.aoa = a.q(optJSONObject);
            }
        }
    }
}
