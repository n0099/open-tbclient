package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bcD;
    private long bcE;
    private com.baidu.live.gift.a.a bcF;
    private long mLogId;
    public String orderId;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.bcD = 0L;
    }

    public long IS() {
        return this.bcD;
    }

    public long IT() {
        return this.bcE;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.gift.a.a IU() {
        return this.bcF;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bcD = jSONObject.optLong("left_scores");
            this.bcE = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            this.orderId = jSONObject.optString("order_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.bcF = com.baidu.live.gift.a.a.H(optJSONObject);
            }
        }
    }
}
