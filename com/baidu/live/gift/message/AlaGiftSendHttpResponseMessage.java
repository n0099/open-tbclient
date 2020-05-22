package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long aMn;
    private long aMo;
    private com.baidu.live.gift.a.a aMp;
    private long mLogId;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.aMn = 0L;
    }

    public long Ax() {
        return this.aMn;
    }

    public long Ay() {
        return this.aMo;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.gift.a.a Az() {
        return this.aMp;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aMn = jSONObject.optLong("left_scores");
            this.aMo = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.aMp = com.baidu.live.gift.a.a.A(optJSONObject);
            }
        }
    }
}
