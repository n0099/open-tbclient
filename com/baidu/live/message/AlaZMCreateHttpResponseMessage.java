package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String aQx;
    private String aQy;
    private long aQz;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.aQx = null;
        this.aQy = null;
        this.aQz = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aQx = jSONObject.optString("biz_url");
            this.aQy = jSONObject.optString("biz_no");
            this.aQz = jSONObject.optLong("cert_id");
        }
    }

    public long DR() {
        return this.aQz;
    }
}
