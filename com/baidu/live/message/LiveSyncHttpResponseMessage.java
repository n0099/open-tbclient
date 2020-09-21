package com.baidu.live.message;

import com.baidu.live.data.bj;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private bj bhI;

    public bj Mn() {
        return this.bhI;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bhI = new bj();
            this.bhI.parserJson(jSONObject);
            if (getError() == 0) {
                com.baidu.live.c.AR().putString("key_live_sync_data", jSONObject.toString());
            }
        }
    }
}
