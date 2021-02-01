package com.baidu.live.message;

import com.baidu.live.data.bv;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private bv bvh;

    public bv Oy() {
        return this.bvh;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bvh = new bv();
            this.bvh.parserJson(jSONObject);
            if (getError() == 0) {
                com.baidu.live.d.xc().putString("key_live_sync_data", jSONObject.toString());
            }
        }
    }
}
