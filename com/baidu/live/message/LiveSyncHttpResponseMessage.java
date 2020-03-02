package com.baidu.live.message;

import com.baidu.live.data.ap;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private ap awO;

    public ap yX() {
        return this.awO;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.awO = new ap();
            this.awO.parserJson(jSONObject);
            if (getError() == 0) {
                com.baidu.live.c.pr().putString("key_live_sync_data", jSONObject.toString());
            }
        }
    }
}
