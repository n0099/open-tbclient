package com.baidu.live.message;

import com.baidu.live.data.ax;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetLiveActivityHttpResponseMessage extends JsonHttpResponsedMessage {
    private ax aZw;

    public ax FV() {
        return this.aZw;
    }

    public GetLiveActivityHttpResponseMessage() {
        super(1021122);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aZw = new ax();
            this.aZw.parserJson(jSONObject);
        }
    }
}
