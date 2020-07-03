package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String aZs;
    private String aZt;
    private long aZu;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.aZs = null;
        this.aZt = null;
        this.aZu = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aZs = jSONObject.optString("biz_url");
            this.aZt = jSONObject.optString("biz_no");
            this.aZu = jSONObject.optLong("cert_id");
        }
    }

    public long Ga() {
        return this.aZu;
    }
}
