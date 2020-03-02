package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String awE;
    private String awF;
    private long awG;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.awE = null;
        this.awF = null;
        this.awG = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.awE = jSONObject.optString("biz_url");
            this.awF = jSONObject.optString("biz_no");
            this.awG = jSONObject.optLong("cert_id");
        }
    }

    public long yT() {
        return this.awG;
    }
}
