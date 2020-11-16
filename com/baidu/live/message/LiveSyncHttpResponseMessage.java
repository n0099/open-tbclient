package com.baidu.live.message;

import com.baidu.live.data.bn;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private bn bmC;

    public bn ND() {
        return this.bmC;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bmC = new bn();
            this.bmC.parserJson(jSONObject);
            if (getError() == 0) {
                com.baidu.live.d.Aq().putString("key_live_sync_data", jSONObject.toString());
            }
        }
    }
}
