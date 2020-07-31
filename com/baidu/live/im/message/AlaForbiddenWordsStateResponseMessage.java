package com.baidu.live.im.message;

import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaForbiddenWordsStateResponseMessage extends JsonHttpResponsedMessage {
    public ImForbiddenStateData aXk;

    public AlaForbiddenWordsStateResponseMessage() {
        super(1021194);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.aXk = new ImForbiddenStateData();
            this.aXk.errno = getError();
            this.aXk.errMsg = getErrorString();
            this.aXk.parseJson(jSONObject);
        }
    }
}
