package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String brx;
    private String bry;
    private long brz;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.brx = null;
        this.bry = null;
        this.brz = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.brx = jSONObject.optString("biz_url");
            this.bry = jSONObject.optString("biz_no");
            this.brz = jSONObject.optLong("cert_id");
        }
    }

    public long MW() {
        return this.brz;
    }
}
