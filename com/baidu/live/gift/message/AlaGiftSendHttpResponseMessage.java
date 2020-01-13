package com.baidu.live.gift.message;

import com.baidu.live.gift.a.a;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long alK;
    private long alL;
    private a alM;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.alK = 0L;
    }

    public long ts() {
        return this.alK;
    }

    public long tt() {
        return this.alL;
    }

    public a tu() {
        return this.alM;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.alK = jSONObject.optLong("left_scores");
            this.alL = jSONObject.optLong("tdou_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.alM = a.q(optJSONObject);
            }
        }
    }
}
