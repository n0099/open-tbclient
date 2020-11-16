package com.baidu.live.message;

import com.baidu.live.data.bj;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AudioGetLiveActivityHttpResponseMessage extends JsonHttpResponsedMessage {
    private bj bmy;

    public bj NA() {
        return this.bmy;
    }

    public AudioGetLiveActivityHttpResponseMessage() {
        super(1031002);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bmy = new bj();
            this.bmy.parserJson(jSONObject);
        }
    }
}
