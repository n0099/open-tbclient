package com.baidu.live.message;

import com.baidu.live.data.as;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private as aQI;

    public as DW() {
        return this.aQI;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aQI = new as();
            this.aQI.parserJson(jSONObject);
            if (getError() == 0) {
                com.baidu.live.c.tG().putString("key_live_sync_data", jSONObject.toString());
            }
        }
    }
}
