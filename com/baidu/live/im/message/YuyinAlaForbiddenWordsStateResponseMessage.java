package com.baidu.live.im.message;

import com.baidu.live.im.data.YuyinImForbiddenStateData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinAlaForbiddenWordsStateResponseMessage extends JsonHttpResponsedMessage {
    public YuyinImForbiddenStateData blT;

    public YuyinAlaForbiddenWordsStateResponseMessage() {
        super(1031054);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.blT = new YuyinImForbiddenStateData();
            this.blT.errno = getError();
            this.blT.errMsg = getErrorString();
            this.blT.parseJson(jSONObject);
        }
    }
}
