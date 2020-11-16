package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String bmv;
    private String bmw;
    private long bmx;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.bmv = null;
        this.bmw = null;
        this.bmx = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bmv = jSONObject.optString("biz_url");
            this.bmw = jSONObject.optString("biz_no");
            this.bmx = jSONObject.optLong("cert_id");
        }
    }

    public long Nz() {
        return this.bmx;
    }
}
