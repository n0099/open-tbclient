package com.baidu.live.tbadk.pay;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ResponseGetPayinfoMessage extends JsonHttpResponsedMessage {
    private PayInfoResultData mPayInfoResultData;

    public ResponseGetPayinfoMessage(int i) {
        super(i);
    }

    public PayInfoResultData getPayInfoResultData() {
        return this.mPayInfoResultData;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.mPayInfoResultData = new PayInfoResultData();
            this.mPayInfoResultData.parserJson(jSONObject);
        }
    }
}
