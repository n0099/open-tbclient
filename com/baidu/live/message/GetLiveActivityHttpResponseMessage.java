package com.baidu.live.message;

import com.baidu.live.data.aw;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetLiveActivityHttpResponseMessage extends JsonHttpResponsedMessage {
    private aw aZy;

    public aw Gb() {
        return this.aZy;
    }

    public GetLiveActivityHttpResponseMessage() {
        super(1021122);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aZy = new aw();
            this.aZy.parserJson(jSONObject);
        }
    }
}
