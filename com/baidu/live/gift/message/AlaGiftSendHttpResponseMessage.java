package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long aVA;
    private long aVB;
    private com.baidu.live.gift.a.a aVC;
    private long mLogId;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.aVA = 0L;
    }

    public long Hc() {
        return this.aVA;
    }

    public long Hd() {
        return this.aVB;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.gift.a.a He() {
        return this.aVC;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aVA = jSONObject.optLong("left_scores");
            this.aVB = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.aVC = com.baidu.live.gift.a.a.E(optJSONObject);
            }
        }
    }
}
