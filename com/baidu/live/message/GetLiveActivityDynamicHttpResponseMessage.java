package com.baidu.live.message;

import com.baidu.live.data.ag;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetLiveActivityDynamicHttpResponseMessage extends JsonHttpResponsedMessage {
    private ag arM;

    public GetLiveActivityDynamicHttpResponseMessage() {
        super(1021126);
    }

    public ag wl() {
        return this.arM;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.arM = new ag();
            this.arM.parserJson(jSONObject);
        }
    }
}
