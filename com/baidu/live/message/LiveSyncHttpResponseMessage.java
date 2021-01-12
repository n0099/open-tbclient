package com.baidu.live.message;

import com.baidu.live.data.bq;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private bq brE;

    public bq Na() {
        return this.brE;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.brE = new bq();
            this.brE.parserJson(jSONObject);
            if (getError() == 0) {
                com.baidu.live.d.xf().putString("key_live_sync_data", jSONObject.toString());
            }
        }
    }
}
