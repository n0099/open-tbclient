package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bhM;
    private long bhN;
    private com.baidu.live.gift.a.a bhO;
    private long mLogId;
    public String orderId;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.bhM = 0L;
    }

    public long HJ() {
        return this.bhM;
    }

    public long HK() {
        return this.bhN;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.gift.a.a HL() {
        return this.bhO;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bhM = jSONObject.optLong("left_scores");
            this.bhN = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            this.orderId = jSONObject.optString("order_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.bhO = com.baidu.live.gift.a.a.N(optJSONObject);
            }
        }
    }
}
