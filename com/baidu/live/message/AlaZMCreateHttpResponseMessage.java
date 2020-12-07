package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String brD;
    private String brE;
    private long brF;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.brD = null;
        this.brE = null;
        this.brF = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.brD = jSONObject.optString("biz_url");
            this.brE = jSONObject.optString("biz_no");
            this.brF = jSONObject.optLong("cert_id");
        }
    }

    public long PS() {
        return this.brF;
    }
}
