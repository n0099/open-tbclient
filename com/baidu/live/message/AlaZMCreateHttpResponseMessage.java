package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String bwA;
    private String bwB;
    private long bwC;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.bwA = null;
        this.bwB = null;
        this.bwC = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bwA = jSONObject.optString("biz_url");
            this.bwB = jSONObject.optString("biz_no");
            this.bwC = jSONObject.optLong("cert_id");
        }
    }

    public long Ox() {
        return this.bwC;
    }
}
