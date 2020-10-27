package com.baidu.live.im.message;

import com.baidu.live.im.data.YuyinImForbiddenStateData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinAlaForbiddenWordsStateResponseMessage extends JsonHttpResponsedMessage {
    public YuyinImForbiddenStateData bkz;

    public YuyinAlaForbiddenWordsStateResponseMessage() {
        super(1031054);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.bkz = new YuyinImForbiddenStateData();
            this.bkz.errno = getError();
            this.bkz.errMsg = getErrorString();
            this.bkz.parseJson(jSONObject);
        }
    }
}
