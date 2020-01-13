package com.baidu.live.message;

import com.baidu.live.data.ao;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private ao asD;

    public ao wF() {
        return this.asD;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.asD = new ao();
            this.asD.parserJson(jSONObject);
        }
    }
}
