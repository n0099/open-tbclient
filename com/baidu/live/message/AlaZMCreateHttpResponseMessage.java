package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String aZq;
    private String aZr;
    private long aZs;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.aZq = null;
        this.aZr = null;
        this.aZs = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aZq = jSONObject.optString("biz_url");
            this.aZr = jSONObject.optString("biz_no");
            this.aZs = jSONObject.optLong("cert_id");
        }
    }

    public long FU() {
        return this.aZs;
    }
}
