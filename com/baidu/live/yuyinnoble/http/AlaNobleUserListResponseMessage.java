package com.baidu.live.yuyinnoble.http;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.yuyinnoble.c.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaNobleUserListResponseMessage extends JsonHttpResponsedMessage {
    private a bUg;

    public AlaNobleUserListResponseMessage() {
        super(1031032);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && getError() == 0) {
            this.bUg = new a();
            this.bUg.parserJson(optJSONObject);
        }
    }

    public a Yd() {
        return this.bUg;
    }
}
