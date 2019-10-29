package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetUserInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public GetUserInfoHttpResponseMessage() {
        super(1021125);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("login_user_info")) != null) {
            optJSONObject.optString("switch");
            String optString = optJSONObject.optString("user_name");
            if (!TextUtils.isEmpty(optString)) {
                TbadkCoreApplication.getCurrentAccountObj().setNameShow(optString);
            }
        }
    }
}
