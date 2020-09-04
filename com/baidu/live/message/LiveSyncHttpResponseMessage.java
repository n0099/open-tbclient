package com.baidu.live.message;

import com.baidu.live.data.be;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LiveSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private be beV;

    public be LM() {
        return this.beV;
    }

    public LiveSyncHttpResponseMessage() {
        super(1021132);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.beV = new be();
            this.beV.parserJson(jSONObject);
            if (getError() == 0) {
                com.baidu.live.c.AD().putString("key_live_sync_data", jSONObject.toString());
            }
        }
    }
}
