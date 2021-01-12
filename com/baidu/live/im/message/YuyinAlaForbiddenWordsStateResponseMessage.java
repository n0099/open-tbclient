package com.baidu.live.im.message;

import com.baidu.live.im.data.YuyinImForbiddenStateData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class YuyinAlaForbiddenWordsStateResponseMessage extends JsonHttpResponsedMessage {
    public YuyinImForbiddenStateData bmm;

    public YuyinAlaForbiddenWordsStateResponseMessage() {
        super(1031054);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.bmm = new YuyinImForbiddenStateData();
            this.bmm.errno = getError();
            this.bmm.errMsg = getErrorString();
            this.bmm.parseJson(jSONObject);
        }
    }
}
