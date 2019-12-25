package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String arH;
    private String arI;
    private long arJ;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.arH = null;
        this.arI = null;
        this.arJ = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.arH = jSONObject.optString("biz_url");
            this.arI = jSONObject.optString("biz_no");
            this.arJ = jSONObject.optLong("cert_id");
        }
    }

    public long wk() {
        return this.arJ;
    }
}
