package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String aka;
    private String akb;
    private long akc;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.aka = null;
        this.akb = null;
        this.akc = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aka = jSONObject.optString("biz_url");
            this.akb = jSONObject.optString("biz_no");
            this.akc = jSONObject.optLong("cert_id");
        }
    }

    public long uo() {
        return this.akc;
    }
}
