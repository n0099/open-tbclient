package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bbp;
    private long bbq;
    private com.baidu.live.gift.a.a bbr;
    private long mLogId;
    public String orderId;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.bbp = 0L;
    }

    public long Iz() {
        return this.bbp;
    }

    public long IA() {
        return this.bbq;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.gift.a.a IB() {
        return this.bbr;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bbp = jSONObject.optLong("left_scores");
            this.bbq = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            this.orderId = jSONObject.optString("order_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.bbr = com.baidu.live.gift.a.a.F(optJSONObject);
            }
        }
    }
}
