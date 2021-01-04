package com.baidu.live.message;

import com.baidu.live.data.bm;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetLiveActivityHttpResponseMessage extends JsonHttpResponsedMessage {
    private bm bwo;

    public bm QS() {
        return this.bwo;
    }

    public GetLiveActivityHttpResponseMessage() {
        super(1021122);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bwo = new bm();
            this.bwo.parserJson(jSONObject);
        }
    }
}
