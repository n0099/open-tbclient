package com.baidu.live.message;

import com.baidu.live.data.bv;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private bv bwH;

    public bv OB() {
        return this.bwH;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bwH = new bv();
            this.bwH.parserJson(jSONObject);
            if (getError() == 0) {
                com.baidu.live.d.xf().putString("key_live_sync_data", jSONObject.toString());
            }
        }
    }
}
