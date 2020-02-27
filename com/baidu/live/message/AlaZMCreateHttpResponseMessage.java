package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String awD;
    private String awE;
    private long awF;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.awD = null;
        this.awE = null;
        this.awF = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.awD = jSONObject.optString("biz_url");
            this.awE = jSONObject.optString("biz_no");
            this.awF = jSONObject.optLong("cert_id");
        }
    }

    public long yS() {
        return this.awF;
    }
}
