package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bk {
    private String aNA;
    private String aNB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(String str) {
        parserJson(str);
    }

    public boolean Ee() {
        return "1".equals(this.aNA) && !TextUtils.isEmpty(this.aNB);
    }

    public String Ef() {
        return this.aNB;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aNA = jSONObject.optString("is_open");
                this.aNB = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
