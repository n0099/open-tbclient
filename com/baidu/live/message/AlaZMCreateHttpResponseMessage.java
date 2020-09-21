package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String bhB;
    private String bhC;
    private long bhD;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.bhB = null;
        this.bhC = null;
        this.bhD = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bhB = jSONObject.optString("biz_url");
            this.bhC = jSONObject.optString("biz_no");
            this.bhD = jSONObject.optLong("cert_id");
        }
    }

    public long Mj() {
        return this.bhD;
    }
}
