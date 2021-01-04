package com.baidu.live.tbadk.util;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes11.dex */
public class CheckBaiduSimResponseMessage extends JsonHttpResponsedMessage {
    public boolean isBaiduSim;
    public boolean isSuc;

    public CheckBaiduSimResponseMessage() {
        super(1003392);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.isSuc = jSONObject.optInt("status") == 0;
            this.isBaiduSim = jSONObject.optInt("product") == 1;
        }
    }
}
