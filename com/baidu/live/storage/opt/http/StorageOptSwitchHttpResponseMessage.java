package com.baidu.live.storage.opt.http;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class StorageOptSwitchHttpResponseMessage extends JsonHttpResponsedMessage {
    public boolean bBC;
    public long bBD;
    public long bBE;
    public long bBF;

    public StorageOptSwitchHttpResponseMessage() {
        super(1021236);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021236 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bBC = optJSONObject.optInt("switch") == 1;
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("internal");
            if (optJSONObject2 != null) {
                this.bBD = optJSONObject2.optLong("show");
                this.bBE = optJSONObject2.optLong("media");
                this.bBF = optJSONObject2.optLong("yuyin");
            }
        }
    }
}
