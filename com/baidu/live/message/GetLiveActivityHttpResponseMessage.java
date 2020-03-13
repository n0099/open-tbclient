package com.baidu.live.message;

import com.baidu.live.data.ak;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetLiveActivityHttpResponseMessage extends JsonHttpResponsedMessage {
    private ak awL;

    public ak yV() {
        return this.awL;
    }

    public GetLiveActivityHttpResponseMessage() {
        super(1021122);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.awL = new ak();
            this.awL.parserJson(jSONObject);
        }
    }
}
