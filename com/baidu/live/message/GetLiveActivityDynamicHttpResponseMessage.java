package com.baidu.live.message;

import com.baidu.live.data.ad;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetLiveActivityDynamicHttpResponseMessage extends JsonHttpResponsedMessage {
    private ad akg;

    public GetLiveActivityDynamicHttpResponseMessage() {
        super(1021126);
    }

    public ad up() {
        return this.akg;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.akg = new ad();
            this.akg.parserJson(jSONObject);
        }
    }
}
