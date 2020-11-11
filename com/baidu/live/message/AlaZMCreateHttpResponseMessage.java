package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String bog;
    private String boh;
    private long boi;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.bog = null;
        this.boh = null;
        this.boi = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bog = jSONObject.optString("biz_url");
            this.boh = jSONObject.optString("biz_no");
            this.boi = jSONObject.optLong("cert_id");
        }
    }

    public long Oi() {
        return this.boi;
    }
}
