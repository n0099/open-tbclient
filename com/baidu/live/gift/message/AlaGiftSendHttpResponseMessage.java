package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bdW;
    private long bdX;
    private com.baidu.live.gift.a.a bdY;
    private long mLogId;
    public String orderId;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.bdW = 0L;
    }

    public long Jt() {
        return this.bdW;
    }

    public long Ju() {
        return this.bdX;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.gift.a.a Jv() {
        return this.bdY;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bdW = jSONObject.optLong("left_scores");
            this.bdX = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            this.orderId = jSONObject.optString("order_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.bdY = com.baidu.live.gift.a.a.K(optJSONObject);
            }
        }
    }
}
