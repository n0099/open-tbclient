package com.baidu.live.im.message;

import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaForbiddenWordsStateResponseMessage extends JsonHttpResponsedMessage {
    public ImForbiddenStateData aNx;

    public AlaForbiddenWordsStateResponseMessage() {
        super(1021187);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.aNx = new ImForbiddenStateData();
            this.aNx.errno = getError();
            this.aNx.errMsg = getErrorString();
            this.aNx.parseJson(jSONObject);
        }
    }
}
