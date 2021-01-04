package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String bwl;
    private String bwm;
    private long bwn;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.bwl = null;
        this.bwm = null;
        this.bwn = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bwl = jSONObject.optString("biz_url");
            this.bwm = jSONObject.optString("biz_no");
            this.bwn = jSONObject.optLong("cert_id");
        }
    }

    public long QR() {
        return this.bwn;
    }
}
