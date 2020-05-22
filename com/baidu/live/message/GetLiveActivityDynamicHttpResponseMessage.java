package com.baidu.live.message;

import com.baidu.live.data.at;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetLiveActivityDynamicHttpResponseMessage extends JsonHttpResponsedMessage {
    private at aWN;

    public GetLiveActivityDynamicHttpResponseMessage() {
        super(1021126);
    }

    public at Fq() {
        return this.aWN;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aWN = new at();
            this.aWN.parserJson(jSONObject);
        }
    }
}
