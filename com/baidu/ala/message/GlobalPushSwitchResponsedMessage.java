package com.baidu.ala.message;

import android.text.TextUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GlobalPushSwitchResponsedMessage extends JsonHttpResponsedMessage {
    public static final int SWITCH_OFF = 0;
    public static final int SWITCH_ON = 1;
    public int push_switch;

    public GlobalPushSwitchResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
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
