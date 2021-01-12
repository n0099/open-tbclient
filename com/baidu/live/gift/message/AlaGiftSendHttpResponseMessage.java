package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bdc;
    private long bdd;
    private com.baidu.live.gift.a.a bde;
    private long mLogId;
    public String orderId;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.bdc = 0L;
    }

    public long Gq() {
        return this.bdc;
    }

    public long Gr() {
        return this.bdd;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.gift.a.a Gs() {
        return this.bde;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bdc = jSONObject.optLong("left_scores");
            this.bdd = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            this.orderId = jSONObject.optString("order_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.bde = com.baidu.live.gift.a.a.L(optJSONObject);
            }
        }
    }
}
