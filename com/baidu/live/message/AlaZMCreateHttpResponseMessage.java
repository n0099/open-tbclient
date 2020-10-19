package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String blr;
    private String bls;
    private long blt;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.blr = null;
        this.bls = null;
        this.blt = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.blr = jSONObject.optString("biz_url");
            this.bls = jSONObject.optString("biz_no");
            this.blt = jSONObject.optLong("cert_id");
        }
    }

    public long No() {
        return this.blt;
    }
}
