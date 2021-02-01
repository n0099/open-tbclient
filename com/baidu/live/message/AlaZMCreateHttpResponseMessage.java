package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String bva;
    private String bvb;
    private long bvc;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.bva = null;
        this.bvb = null;
        this.bvc = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bva = jSONObject.optString("biz_url");
            this.bvb = jSONObject.optString("biz_no");
            this.bvc = jSONObject.optLong("cert_id");
        }
    }

    public long Ou() {
        return this.bvc;
    }
}
