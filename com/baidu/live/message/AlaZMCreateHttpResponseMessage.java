package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String beM;
    private String beN;
    private long beO;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.beM = null;
        this.beN = null;
        this.beO = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.beM = jSONObject.optString("biz_url");
            this.beN = jSONObject.optString("biz_no");
            this.beO = jSONObject.optLong("cert_id");
        }
    }

    public long LI() {
        return this.beO;
    }
}
