package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String bmM;
    private String bmN;
    private long bmO;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.bmM = null;
        this.bmN = null;
        this.bmO = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bmM = jSONObject.optString("biz_url");
            this.bmN = jSONObject.optString("biz_no");
            this.bmO = jSONObject.optLong("cert_id");
        }
    }

    public long NI() {
        return this.bmO;
    }
}
