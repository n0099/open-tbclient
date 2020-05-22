package com.baidu.live.message;

import com.baidu.live.data.ax;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private ax aWT;

    public ax Fu() {
        return this.aWT;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aWT = new ax();
            this.aWT.parserJson(jSONObject);
            if (getError() == 0) {
                com.baidu.live.c.uN().putString("key_live_sync_data", jSONObject.toString());
            }
        }
    }
}
