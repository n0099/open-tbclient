package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long aOT;
    private long aOU;
    private com.baidu.live.gift.a.a aOV;
    private long mLogId;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.aOT = 0L;
    }

    public long AX() {
        return this.aOT;
    }

    public long AY() {
        return this.aOU;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.gift.a.a AZ() {
        return this.aOV;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aOT = jSONObject.optLong("left_scores");
            this.aOU = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.aOV = com.baidu.live.gift.a.a.C(optJSONObject);
            }
        }
    }
}
