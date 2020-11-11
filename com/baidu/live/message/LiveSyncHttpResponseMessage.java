package com.baidu.live.message;

import com.baidu.live.data.bn;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private bn bon;

    public bn Om() {
        return this.bon;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bon = new bn();
            this.bon.parserJson(jSONObject);
            if (getError() == 0) {
                com.baidu.live.d.AZ().putString("key_live_sync_data", jSONObject.toString());
            }
        }
    }
}
