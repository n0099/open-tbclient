package com.baidu.live.gift.message;

import com.baidu.live.gift.a.a;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long aGA;
    private long aGB;
    private a aGC;
    private long aGz;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.aGz = 0L;
    }

    public long zj() {
        return this.aGz;
    }

    public long zk() {
        return this.aGA;
    }

    public long zl() {
        return this.aGB;
    }

    public a zm() {
        return this.aGC;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aGz = jSONObject.optLong("left_scores");
            this.aGA = jSONObject.optLong("tdou_num");
            this.aGB = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.aGC = a.w(optJSONObject);
            }
        }
    }
}
