package com.baidu.live.view.web.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.live.view.web.a {
    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "followBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void jm(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("user_id");
                    if (!TextUtils.isEmpty(optString)) {
                        String[] split = optString.contains(",") ? optString.split(",") : new String[]{optString};
                        if (split != null) {
                            com.baidu.live.view.a.Yo().o(split);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
