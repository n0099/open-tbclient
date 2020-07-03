package com.baidu.live.message;

import com.baidu.live.data.bb;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private bb aZB;

    public bb Ge() {
        return this.aZB;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aZB = new bb();
            this.aZB.parserJson(jSONObject);
            if (getError() == 0) {
                com.baidu.live.c.vf().putString("key_live_sync_data", jSONObject.toString());
            }
        }
    }
}
