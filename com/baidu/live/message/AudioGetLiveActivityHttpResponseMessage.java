package com.baidu.live.message;

import com.baidu.live.data.bk;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AudioGetLiveActivityHttpResponseMessage extends JsonHttpResponsedMessage {
    private bk brG;

    public bk PT() {
        return this.brG;
    }

    public AudioGetLiveActivityHttpResponseMessage() {
        super(1031002);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.brG = new bk();
            this.brG.parserJson(jSONObject);
        }
    }
}
