package com.baidu.live.gift.message;

import com.baidu.live.gift.a.a;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long aGF;
    private long aGG;
    private long aGH;
    private a aGI;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.aGF = 0L;
    }

    public long zi() {
        return this.aGF;
    }

    public long zj() {
        return this.aGG;
    }

    public long zk() {
        return this.aGH;
    }

    public a zl() {
        return this.aGI;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aGF = jSONObject.optLong("left_scores");
            this.aGG = jSONObject.optLong("tdou_num");
            this.aGH = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.aGI = a.w(optJSONObject);
            }
        }
    }
}
