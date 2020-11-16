package com.baidu.live.view.web.a;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.live.view.web.a {
    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "followBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iI(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("user_id");
                    if (!TextUtils.isEmpty(optString)) {
                        String[] split = optString.contains(Constants.ACCEPT_TIME_SEPARATOR_SP) ? optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP) : new String[]{optString};
                        if (split != null) {
                            com.baidu.live.view.a.VO().o(split);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
