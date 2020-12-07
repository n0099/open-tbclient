package com.baidu.live.yuyinnoble.http;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.yuyinnoble.c.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaNobleUserListResponseMessage extends JsonHttpResponsedMessage {
    private a bXM;

    public AlaNobleUserListResponseMessage() {
        super(1031032);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && getError() == 0) {
            this.bXM = new a();
            this.bXM.parserJson(optJSONObject);
        }
    }

    public a ZX() {
        return this.bXM;
    }
}
