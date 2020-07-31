package com.baidu.live.gift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long aQm;
    private long aQn;
    private com.baidu.live.gift.a.a aQo;
    private long mLogId;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.aQm = 0L;
    }

    public long Bz() {
        return this.aQm;
    }

    public long BA() {
        return this.aQn;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.gift.a.a BB() {
        return this.aQo;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aQm = jSONObject.optLong("left_scores");
            this.aQn = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.aQo = com.baidu.live.gift.a.a.C(optJSONObject);
            }
        }
    }
}
