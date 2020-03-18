package com.baidu.live.gift.message;

import com.baidu.live.gift.a.a;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long aoh;
    private long aoi;
    private long aoj;
    private a aok;

    public AlaGiftSendHttpResponseMessage() {
        super(1021015);
        this.aoh = 0L;
    }

    public long uO() {
        return this.aoh;
    }

    public long uP() {
        return this.aoi;
    }

    public long uQ() {
        return this.aoj;
    }

    public a uR() {
        return this.aok;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021015) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aoh = jSONObject.optLong("left_scores");
            this.aoi = jSONObject.optLong("tdou_num");
            this.aoj = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.aok = a.q(optJSONObject);
            }
        }
    }
}
