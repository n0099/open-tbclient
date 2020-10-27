package com.baidu.live.message;

import com.baidu.live.data.bh;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AudioGetLiveActivityHttpResponseMessage extends JsonHttpResponsedMessage {
    private bh bmP;

    public bh NJ() {
        return this.bmP;
    }

    public AudioGetLiveActivityHttpResponseMessage() {
        super(1031002);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bmP = new bh();
            this.bmP.parserJson(jSONObject);
        }
    }
}
