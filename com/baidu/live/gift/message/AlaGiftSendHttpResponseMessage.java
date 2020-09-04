package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long aVC;
    private long aVD;
    private com.baidu.live.gift.a.a aVE;
    private long mLogId;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.aVC = 0L;
    }

    public long Hc() {
        return this.aVC;
    }

    public long Hd() {
        return this.aVD;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.gift.a.a He() {
        return this.aVE;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aVC = jSONObject.optLong("left_scores");
            this.aVD = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.aVE = com.baidu.live.gift.a.a.E(optJSONObject);
            }
        }
    }
}
