package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String awF;
    private String awG;
    private long awH;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.awF = null;
        this.awG = null;
        this.awH = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.awF = jSONObject.optString("biz_url");
            this.awG = jSONObject.optString("biz_no");
            this.awH = jSONObject.optLong("cert_id");
        }
    }

    public long yT() {
        return this.awH;
    }
}
