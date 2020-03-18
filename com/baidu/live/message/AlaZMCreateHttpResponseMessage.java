package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String awP;
    private String awQ;
    private long awR;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.awP = null;
        this.awQ = null;
        this.awR = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.awP = jSONObject.optString("biz_url");
            this.awQ = jSONObject.optString("biz_no");
            this.awR = jSONObject.optLong("cert_id");
        }
    }

    public long yY() {
        return this.awR;
    }
}
