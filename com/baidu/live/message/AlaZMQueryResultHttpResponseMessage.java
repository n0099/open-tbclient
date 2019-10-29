package com.baidu.live.message;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaZMQueryResultHttpResponseMessage extends JsonHttpResponsedMessage {
    private int akd;
    private String mMsg;

    public AlaZMQueryResultHttpResponseMessage() {
        super(1021063);
        this.akd = 0;
        this.mMsg = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.akd = jSONObject.optInt("result");
            this.mMsg = jSONObject.optString(TiebaInitialize.LogFields.REASON);
        }
    }
}
