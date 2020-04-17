package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaZMCreateHttpResponseMessage extends JsonHttpResponsedMessage {
    private String aQs;
    private String aQt;
    private long aQu;

    public AlaZMCreateHttpResponseMessage() {
        super(1021062);
        this.aQs = null;
        this.aQt = null;
        this.aQu = 0L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aQs = jSONObject.optString("biz_url");
            this.aQt = jSONObject.optString("biz_no");
            this.aQu = jSONObject.optLong("cert_id");
        }
    }

    public long DS() {
        return this.aQu;
    }
}
