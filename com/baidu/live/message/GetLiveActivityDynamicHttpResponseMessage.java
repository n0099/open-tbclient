package com.baidu.live.message;

import com.baidu.live.data.ax;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetLiveActivityDynamicHttpResponseMessage extends JsonHttpResponsedMessage {
    private ax aZx;

    public GetLiveActivityDynamicHttpResponseMessage() {
        super(1021126);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aZx = new ax();
            this.aZx.parserJson(jSONObject);
        }
    }
}
