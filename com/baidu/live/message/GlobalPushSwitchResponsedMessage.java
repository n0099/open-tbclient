package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GlobalPushSwitchResponsedMessage extends JsonHttpResponsedMessage {
    public int push_switch;

    public GlobalPushSwitchResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(jSONObject.optString("data"))) {
                    this.push_switch = jSONObject.optJSONObject("data").optInt("push_switch");
                }
            } catch (Exception e) {
            }
        }
    }
}
