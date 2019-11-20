package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String ajI;
    private String ajJ;
    private long ajK;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.ajI = null;
        this.ajJ = null;
        this.ajK = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.ajI = jSONObject.optString("biz_url");
            this.ajJ = jSONObject.optString("biz_no");
            this.ajK = jSONObject.optLong("cert_id");
        }
    }

    public long up() {
        return this.ajK;
    }
}
