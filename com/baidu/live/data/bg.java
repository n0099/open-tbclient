package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bg {
    private String aKE;
    private String aKF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(String str) {
        parserJson(str);
    }

    public boolean Dk() {
        return "1".equals(this.aKE) && !TextUtils.isEmpty(this.aKF);
    }

    public String Dl() {
        return this.aKF;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aKE = jSONObject.optString("is_open");
                this.aKF = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
