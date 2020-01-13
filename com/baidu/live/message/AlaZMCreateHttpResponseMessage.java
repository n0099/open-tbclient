package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String ast;
    private String asu;
    private long asv;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.ast = null;
        this.asu = null;
        this.asv = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.ast = jSONObject.optString("biz_url");
            this.asu = jSONObject.optString("biz_no");
            this.asv = jSONObject.optLong("cert_id");
        }
    }

    public long wB() {
        return this.asv;
    }
}
