package com.baidu.live.message;

import com.baidu.live.data.af;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private af ajT;

    public af ut() {
        return this.ajT;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.ajT = new af();
            this.ajT.parserJson(jSONObject);
        }
    }
}
