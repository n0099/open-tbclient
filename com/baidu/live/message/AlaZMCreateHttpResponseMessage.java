package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String aWI;
    private String aWJ;
    private long aWK;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.aWI = null;
        this.aWJ = null;
        this.aWK = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aWI = jSONObject.optString("biz_url");
            this.aWJ = jSONObject.optString("biz_no");
            this.aWK = jSONObject.optLong("cert_id");
        }
    }

    public long Fp() {
        return this.aWK;
    }
}
