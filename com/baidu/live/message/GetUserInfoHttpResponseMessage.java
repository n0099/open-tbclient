package com.baidu.live.message;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetUserInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public long userId;
    public String userName;

    public GetUserInfoHttpResponseMessage() {
        super(1021125);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("login_user_info")) != null) {
            this.userId = optJSONObject.optLong("user_id");
            this.userName = optJSONObject.optString("user_name");
            if (!TextUtils.isEmpty(this.userName)) {
                Log.i("ModifyNicknameHelper", "@@ ModifyNickname GetUserInfoHttpResponseMessage success");
                TbadkCoreApplication.getCurrentAccountObj().setNameShow(this.userName);
            }
        }
    }
}
