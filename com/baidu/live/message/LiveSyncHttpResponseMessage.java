package com.baidu.live.message;

import com.baidu.live.data.ak;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private ak arR;

    public ak wo() {
        return this.arR;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.arR = new ak();
            this.arR.parserJson(jSONObject);
        }
    }
}
