package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String beK;
    private String beL;
    private long beM;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.beK = null;
        this.beL = null;
        this.beM = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.beK = jSONObject.optString("biz_url");
            this.beL = jSONObject.optString("biz_no");
            this.beM = jSONObject.optLong("cert_id");
        }
    }

    public long LI() {
        return this.beM;
    }
}
