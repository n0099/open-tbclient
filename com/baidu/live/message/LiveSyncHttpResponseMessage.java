package com.baidu.live.message;

import com.baidu.live.data.ap;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private ap awZ;

    public ap zc() {
        return this.awZ;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.awZ = new ap();
            this.awZ.parserJson(jSONObject);
            if (getError() == 0) {
                com.baidu.live.c.pw().putString("key_live_sync_data", jSONObject.toString());
            }
        }
    }
}
